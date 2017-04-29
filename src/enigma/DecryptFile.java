/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Paul
 */
public class DecryptFile extends EnigmaController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent k) {
        String key = theView.getkeytext();
        String fileName = location;
        String outputfilename;

        if ("".equals(outputlocation)) {
            outputfilename = location.substring(0, location.length() - 4) + "Decrypted.txt";
        } else {
            outputfilename = outputlocation;
        }
        boolean loadFromClasspath = true;
        BufferedReader reader = null;
        try {
            if (loadFromClasspath) {
                // loading from classpath
                File initialFile = new File(location);
                InputStream in = new FileInputStream(initialFile);
                reader = new BufferedReader(new InputStreamReader(in));
            } else {
                // load from file system
                reader = new BufferedReader(new FileReader(new File(fileName)));
            }
            String line;

            File outputfile = new File(outputfilename);
            FileWriter fileout = new FileWriter(outputfile);
            while ((line = reader.readLine()) != null) {
                //break line upinto bytes and feed into encrypt
                int leftOver = line.length() % 24;
                int fullTimes = line.length() / 24;
                for (int a = 0; a < fullTimes; a++) {
                    String detext = line.substring(a * 24, (24 * a) + 24);
                    System.out.println("DETEXT IS: " + detext);
                    int[][] nfo = DecryptModel.decipher(base64Toint(detext), format(key, "Key", NK));

                 //   fileout.write(intTostr(nfo));

                }
                if (leftOver > 0) {
                    String detext = line.substring(line.length() - leftOver, line.length());
                    int[][] nfo = DecryptModel.decipher(base64Toint(detext), format(key, "Key", NK));
                   // fileout.write(intTostr(nfo));
                }
            }
            fileout.close();
        } catch (IOException c) {
            //JOptionPane.showMessageDialog(null, c.getMessage() + location, "File Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                }
            }
        }

    }

}
