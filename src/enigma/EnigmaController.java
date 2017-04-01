/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author psteu_000
 * This is the Controller for the MVC model
 */
public class EnigmaController {

    private final EnigmaView theView;
    private final Encrypt EncryptModel;
    private final Decrypt DecryptModel;
    private String location;

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

        theView.addEncryptListener(new EncryptListener());
        theView.addDecryptListener(new DecryptListener());
        theView.addFileSelector(new FileSelector());
        theView.addGoEncryptFile(new EncryptFile());
        theView.addGoDecryptFile(new DecryptFile());
    }

    class FileSelector implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(theView);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                //System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                location = selectedFile.getAbsolutePath();
                theView.setIsFileText(location);
                //Enable the buttons 
                //Also set filter to only text files 
            }
        }
    }

    class EncryptListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Gets the key and the plaintext
            String key = "";
            String Entext = "";

            //put in try catch block
            try {
                key = theView.getkeytext();
                System.out.println(key + " This is the Input Key");   //Prints out the input of the key for testing purposes
                Entext = theView.getentext();
                System.out.println(Entext + " This is the input plaintext");

                //check if input is too big
                if (Entext.length() > 16) { //16 is 1 byte so 128 bits
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Error: Please enter a Plaintext value less than 128 bits \n ie. Thats my Kung Fu", "Error", JOptionPane.ERROR_MESSAGE);
                    //System.out.println(" Entext ="+Entext.length() + " key = "+ key.length());
                } else if (key.length() > 16) { //16 is 1 byte so 128 bits
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Error: Please enter a key value less than 128 bits \n ie. Two One Nine Two ", "Error", JOptionPane.ERROR_MESSAGE);
                    //System.out.println(" Entext ="+Entext.length() + " key = "+ key.length());
                }

                //check if padding is needed
                if (Entext.length() < 16) {
                    Entext = padding(Entext);
                } else if (key.length() < 16) {
                    key = padding(key);
                }
                if ((Entext.length() == 16) && (key.length() == 16)) {
                    int[][] one = new int[4][4];
                    int[][] two = new int [4][4];
                    int[][] nfo;
                    String fout;
                    //one = formatStrToInt(Entext); //is the formatted plaintext
                    //two = formatStrToInt(key); //is formatted key
                    nfo = EncryptModel.Encipher(one, two);
                    fout = formatIntToStr(nfo);
                    theView.setEncryptTextOutput(fout);
                }

            } catch (Exception abc) {
                abc.getMessage();
            }

        }

    }

    public String padding(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int[][] formatStrToInt(String Entext) {
        int[][] state1 = new int[4][4];
        int count = 0;
        for(int c = 0; c < 4; c++){
            for(int r = 0; r < 4; r++){
                state1[c][r] = Integer.parseInt(Entext.substring(count, count));
            }
        }
        return state1;
    }

    public String formatIntToStr(int[][] nfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class DecryptListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String key = "";
            String Detext = "";
            int[][] out;
            String outstring;
            try {
                key = theView.getkeytext();
                System.out.println(key + " This is the input key");
                Detext = theView.getdetext();
                System.out.println(Detext + " This is the input ciphertext");

                //check if input is too big
                if (Detext.length() > 16) { //16 is 1 byte so 128 bits
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Error: Please enter a Cipher value less than 128 bits \n ie. Thats my Kung Fu", "Error", JOptionPane.ERROR_MESSAGE);
                    //System.out.println(" Entext ="+Entext.length() + " key = "+ key.length());
                } else if (key.length() > 16) { //16 is 1 byte so 128 bits
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Error: Please enter a key value less than 128 bits \n ie. Two One Nine Two ", "Error", JOptionPane.ERROR_MESSAGE);
                    //System.out.println(" Entext ="+Entext.length() + " key = "+ key.length());
                }

                //check if padding is needed
                if (Detext.length() < 16) {
                    Detext = padding(Detext);
                } else if (key.length() < 16) {
                    key = padding(key);
                }

                if ((Detext.length() == 16) && (key.length() == 16)) {
                    int[][] one;
                    int[][] two;
                    int[][] nfo;
                    String fout;
                    one = formatStrToInt(Detext); //is the formatted plaintext
                    two = formatStrToInt(key); //is formatted key
                    nfo = DecryptModel.decipher(one, two);
                    fout = formatIntToStr(nfo);
                    theView.setDecryptTextOutput(fout);
                }
            } catch (HeadlessException a) {
                a.getMessage();
            }
            // theView.setentext(outstring);

        }
    }
}
