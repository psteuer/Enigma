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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul
 */
class DecryptFile extends EnigmaController implements ActionListener {

    public DecryptFile(EnigmaView theView, Encrypt WEncryptModel, Decrypt DecryptModel) {
        super(theView, WEncryptModel, DecryptModel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("hihihi");
        String key = theView.getkeytext();
        String fileName = location;
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

            while ((line = reader.readLine()) != null) {
                //break line upinto bytes and feed into encrypt
                int leftOver = line.length() % 16;
                int fullTimes = line.length() / 16;
                for (int a = 0; a < fullTimes; a++) {
                    String Entext = "";
                    Entext = line.substring(a, 16);
                    int[][] nfo;
                    nfo = DecryptModel.decipher(format(Entext, "CipherText"), format(key, "Key"));
                    //create file and print formatted NFO to it
                }
                String Entext = "";
                Entext = line.substring(line.length() - leftOver, line.length());
                int[][] nfo;
                nfo = DecryptModel.decipher(format(Entext, "CipherText"), format(key, "Key"));
                //create file and print formatted NFO to it
            }

        } catch (IOException c) {
            JOptionPane.showMessageDialog(null, c.getMessage() + location, "File Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(DecryptFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
