/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.Base64;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author psteu_000 This is the Controller for the MVC model
 */
public class EnigmaController {

    public final EnigmaView theView;
    public final Encrypt EncryptModel;
    public final Decrypt DecryptModel;
    public String location = "";

    public EnigmaController(EnigmaView theView, Encrypt WEncryptModel, Decrypt DecryptModel) {
        this.theView = theView;
        this.EncryptModel = WEncryptModel;
        this.DecryptModel = DecryptModel;
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {

        }
        theView.setIcon();
        theView.setVisible(true);
        theView.setResizable(false);
        theView.btnEnableDisable(false);

        theView.addEncryptListener(new EncryptListener());
        theView.addDecryptListener(new DecryptListener());
        theView.addFileSelector(new FileSelector());
        theView.addGoEncryptFile(new EncryptFile());
        theView.addGoDecryptFile(new DecrypFile1());   //////////////********************
        theView.addRand(new KeyRand());
    }

    class DecrypFile1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
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

    class KeyRand implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String keynew = "";
            for (int a = 0; a < 16; a++) {
                Random r = new Random();
                char c = (char) (r.nextInt(26) + 'a');
                keynew = keynew + c;
            }
            theView.setkeytext(keynew);
        }
    }

    class FileSelector implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            fileChooser.setFileFilter(filter);
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(theView);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                location = selectedFile.getAbsolutePath();
                theView.setIsFileText(location);
                theView.btnEnableDisable(true);
            }
        }

    }

    class EncryptListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String key;
            String Entext;
            try {
                key = theView.getkeytext();
                Entext = theView.getentext();
                int[][] nfo;
                nfo = EncryptModel.Encipher(format(Entext, "PlainText"), format(key, "Key"));
                //Sets the formatted output to textbox
                theView.setEncryptTextOutput(formatIntToStr(nfo));

            } catch (Exception abc) {
                abc.getMessage();
            }

        }

    }

    class DecryptListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String key;
            String Detext;
            try {
                key = theView.getkeytext();
                Detext = theView.getdetext();

                int[][] nfo;
                nfo = DecryptModel.decipher(format(Detext, "CipherText"), format(key, "Key"));
                theView.setDecryptTextOutput(formatIntToStr(nfo));

            } catch (Exception abc) {
                abc.getMessage();
            }

        }
    }

    /*
    INPUT: String input - to convert, type: 1 is Key, 2 is Input
     */
    public int[][] format(String in, String type) {
        int[][] formattedIn; //formatted entext
        //check if input is too big
        if (in.length() > 16) { //16 is 1 byte so 128 bits
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Error: Please enter a" + type + "value less than 128 bits \n ie. Thats my Kung Fu", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //check if padding is needed
        if (in.length() < 16) {
            in = padding(in);
        }
        formattedIn = formatStrToInt(in, type); //is the formatted plaintext
        return formattedIn;
    }

    public String padding(String key) {
        int len = key.length();
        String space = new String(new char[16 - len]).replace('\0', ' ');
        key = key + space;
        return key;
    }

    public int[][] formatStrToInt(String Entext, String type) {
        int[] ans = new int[16];
        for (int a = 0; a < 16; a++) {
            char[] arrayOfChars = Entext.toCharArray();
            String arrayOfBytes = String.format("0x%02x", (int) arrayOfChars[a]);
            ans[a] = Integer.decode(arrayOfBytes);
        }
        int[][] state = new int[4][4];
        int count = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if ("PlainText".equals(type) || "CipherText".equals(type)) {
                    state[c][r] = (int) ans[count];  //BUG - simple need to go back and re work 
                } else {
                    state[r][c] = (int) ans[count];  //BUG - simple need to go back and re work 

                }
                count++;
            }
        }

        return state;
    }

    //error
    public String formatIntToStr(int[][] nfo) throws UnsupportedEncodingException {
        int[][] CipherText = {{0x29, 0x57, 0x40, 0x1a}, {0xc3, 0x14, 0x22, 0x02}, {0x50, 0x20, 0x99, 0xD7}, {0x5f, 0xf6, 0xb3, 0x3A}};
        nfo = CipherText;
        byte[] n = new byte[16];
        int count = 0;

        //int[] list = new int[16];
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                n[count] = (byte) nfo[r][c];
                count++;
            }
        }

        //System.out.println("N = ");
        //System.out.println(Arrays.toString(n));
        String out = "";
        // String out = new String(Base64.encodeBase64(n));
        //String base64encodedString = Base64.getEncoder().encodeToString(out.getBytes("utf-8"));
        // System.out.println("OUTPUT is: " + out);
        return out;
    }

    //Testing function
    public void printRows(int[][] key) {
        int[][] pivot = new int[key[0].length][];
        for (int row = 0; row < key[0].length; row++) {
            pivot[row] = new int[key.length];
        }

        for (int row = 0; row < key.length; row++) {
            for (int col = 0; col < key[row].length; col++) {
                pivot[col][row] = key[row][col];
            }
        }
        for (int[] pivot1 : pivot) {
            System.out.println(Arrays.toString(pivot1));
        }

    }
}
