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
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
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
    public String outputlocation = "";
    public int NB;
    public int NK;
    public int NR;
    public int keySize;
    public KeyRand keyRand = null;
    public DecryptFile1 decryptFile = null;
    public EncryptListener encryptListener = null;
    public DecryptListener decryptlistener = null;
    public FileSelector fileSelector = null;
    public static EncryptFile1 encryptFile = null;
    public OutputFile outputFile = null;

    /**
     * Constructor for controller
     *Declares the instances of all the other classes
     * Uses state pattern to get key size
     */
    public EnigmaController() {

        //Calls the given state and which corrisponds to the variables
        Context state = new Context();
        //If you one commented you can see how my code reacts to different key sizes
        OneTwentyEight size = new OneTwentyEight();
        // TwoFiftySix size = new TwoFiftySix();
        //OneNineTwo size = new OneNineTwo();
        size.set(state);
        NB = size.getNB();
        NR = size.getNR();
        NK = size.getNK();
        keySize = NB * NK;

        theView = new EnigmaView();
        EncryptModel = new Encrypt(NB, NR, NK);
        DecryptModel = new Decrypt(NB, NR, NK);
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

        if (encryptListener == null) {
            encryptListener = new EncryptListener();
        }
        theView.addEncryptListener(encryptListener);

        if (decryptlistener == null) {
            decryptlistener = new DecryptListener();
        }
        theView.addDecryptListener(decryptlistener);

        if (fileSelector == null) {
            fileSelector = new FileSelector();
        }
        theView.addFileSelector(fileSelector);

        if (encryptFile == null) {
            encryptFile = new EncryptFile1();
        }
        theView.addGoEncryptFile(encryptFile);
        if (decryptFile == null) {
            decryptFile = new DecryptFile1();
        }
        theView.addGoDecryptFile(decryptFile);

        if (keyRand == null) {
            keyRand = new KeyRand();
        }
        theView.addRand(keyRand);

        if (outputFile == null) {
            outputFile = new OutputFile();
        }
        theView.addOutputFileSelector(outputFile);

    }

    /**
     * Listens for OutputFile button
     */
    class OutputFile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            fileChooser.setFileFilter(filter);
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(theView);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                outputlocation = selectedFile.getAbsolutePath();
                theView.setIsFileText(outputlocation);
                theView.btnEnableDisable(true);
            }
        }
    }

    /**
     * Listens for Encrypt File button
     */
    class EncryptFile1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String key = theView.getkeytext();
            String fileName = location;
            String outputfilename;
            if ("".equals(outputlocation)) {
                outputfilename = location.substring(0, location.length() - 4) + "Encrypted.txt";
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
                    int leftOver = line.length() % 16;
                    int fullTimes = line.length() / 16;
                    for (int a = 0; a < fullTimes; a++) {
                        String Entext = line.substring(a * 16, 16 + (a * 16));
                        System.out.println("Entext is : " + Entext);
                        int[][] nfo = EncryptModel.Encipher(format(Entext, "PlainText", 4), format(key, "Key", NK));
                        fileout.write(formatIntToStr(nfo));

                    }
                    if (leftOver > 0) {
                        String Entext = line.substring(line.length() - leftOver, line.length());
                        int[][] nfo = EncryptModel.Encipher(format(Entext, "PlainText", 4), format(key, "Key", NK));
                        fileout.write(formatIntToStr(nfo));
                    }
                }
                fileout.close();
            } catch (IOException c) {
                JOptionPane.showMessageDialog(null, c.getMessage() + location, "File Error", JOptionPane.ERROR_MESSAGE);
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

    /**
     * Listens for Decrypt File button
     */
    class DecryptFile1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
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
                        int[][] nfo = DecryptModel.decipher(base64Toint(detext), format(key, "Key", NK));
                        fileout.write(intTostr(nfo, false));

                    }
                    if (leftOver > 0) {
                        String detext = line.substring(line.length() - leftOver, line.length());
                        int[][] nfo = DecryptModel.decipher(base64Toint(detext), format(key, "Key", NK));
                        fileout.write(intTostr(nfo, true));
                    }
                }
                fileout.close();
            } catch (IOException c) {
                JOptionPane.showMessageDialog(null, c.getMessage() + location, "File Error", JOptionPane.ERROR_MESSAGE);
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

    /**
     * Listens for Random Key button
     */
    class KeyRand implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String keynew = "";
            for (int a = 0; a < keySize; a++) {
                Random r = new Random();
                char c = (char) (r.nextInt(26) + 'a');
                keynew = keynew + c;
            }
            theView.setkeytext(keynew);
        }
    }

    /**
     * Listens for Input File Selector Button
     */
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

    /**
     * Listens for Encrypt button Pulls the Key and plaintext from the view
     */
    class EncryptListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String key;
            String Entext;
            try {
                key = theView.getkeytext();
                Entext = theView.getentext();
                int[][] nfo;
                nfo = EncryptModel.Encipher(format(Entext, "PlainText", 4), format(key, "Key", NK));
                theView.setEncryptTextOutput(formatIntToStr(nfo));
            } catch (Exception abc) {
                abc.getMessage();
            }
        }
    }

    /**
     * Listens for the Decrypt button Pulls the Key and plaintext from the view
     */
    class DecryptListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String key;
            String Detext;
            try {
                key = theView.getkeytext();
                Detext = theView.getdetext();
                int[][] nfo = DecryptModel.decipher(base64Toint(Detext), format(key, "Key", NK));
                theView.setDecryptTextOutput(intTostr(nfo, false));
            } catch (Exception abc) {
                abc.getMessage();
            }

        }
    }

    /**
     * Takes string and outputs base64 integer, for the input of decrypt
     *
     * @param Detext
     * @return InBase64, integers representation of base64 bytes
     */
    public int[][] base64Toint(String Detext) {
        byte[] decodedBytes = Base64.getDecoder().decode(Detext);
        int[][] InBase64 = new int[4][4];
        int count = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                InBase64[r][c] = decodedBytes[count];
                count++;
            }
        }
        return InBase64;
    }

    /**
     * For use in formatting the output of Decrypt
     *
     * @param input
     * @param end is this the end of a line
     * @return Normal ASCII string of characters
     */
    public String intTostr(int[][] input, boolean end) {
        StringBuilder out = new StringBuilder();
        int[] temp = new int[16];
        int count = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                temp[count] = input[c][r];
                out.append(Character.toString((char) temp[count]));
                count++;

            }
        }

        String formattedOut = out.toString();
        String a;
        if (formattedOut.endsWith("  ")) {
            a = formattedOut.trim() + '\n';

        } else {
            a = formattedOut;
        }
        if (end) {
            a = formattedOut.trim() + '\n';
            System.out.println(formattedOut.trim() + '\n');
        }
        return a;
    }

    /**
     * General Formatting function for plaintext to 2D integer array
     *
     * @param in
     * @param type 1 for the key and 2 for plaintext input
     * @param blocklength
     * @return formattedIn this is the correctly formated integer array
     */
    public int[][] format(String in, String type, int blocklength) {
        int[][] formattedIn = new int[NB][blocklength]; //formatted entext
        int blocklengthbytes = blocklength * 4;
        //check if input is too big
        if (in.length() > blocklengthbytes) { //16 is 1 byte so 128 bits
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Error: Please enter a " + type + " value less than " + blocklengthbytes + " Bytes \n ie. Thats my Kung Fu", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (in.length() < blocklengthbytes) {
            in = padding(in, blocklength);
        }
        if (in.length() == blocklengthbytes) {
            formattedIn = formatStrToInt(in, type, blocklength); //is the formatted plaintext
        }
        return formattedIn;
    }

    /**
     * Adds padding for format function
     *
     * @param strpadded
     * @param blocklength length of block, so for state array, 4 and keys could
     * be 4,6,8
     * @return strpadded, should be length of 16 bytes
     */
    public String padding(String strpadded, int blocklength) {
        int len = strpadded.length();
        String space = new String(new char[(blocklength * 4) - len]).replace('\0', ' '); //(blocklength * 4)
        strpadded = strpadded + space;
        return strpadded;
    }

    /**
     * Formats string to Integer called by format
     *
     * @param Entext
     * @param type
     * @param blocklength
     * @return state array as integer
     */
    public int[][] formatStrToInt(String Entext, String type, int blocklength) {
        int[] ans = new int[blocklength * 4];
        for (int a = 0; a < (blocklength * 4); a++) {
            char[] arrayOfChars = Entext.toCharArray();
            String arrayOfBytes = String.format("0x%02x", (int) arrayOfChars[a]);
            ans[a] = Integer.decode(arrayOfBytes);
        }
        int[][] state = new int[NB][blocklength];
        int count = 0;
        for (int r = 0; r < NB; r++) {
            for (int c = 0; c < blocklength; c++) {
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

    /**
     * Takes integer array and outputs base64 string, for use to encode the
     * output of encrypt
     *
     * @param nfo, not formatted integer
     * @return string encoded in base64
     */
    public String formatIntToStr(int[][] nfo) {
        byte[] n = new byte[16];
        int count = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                n[count] = (byte) nfo[r][c];
                count++;
            }
        }
        byte[] encodedBytes = Base64.getEncoder().encode(n);
        return new String(encodedBytes);
    }
}
