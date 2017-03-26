/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author psteu_000
 */
//This is the Controller for the MVC model
public class EnigmaController {

    private final EnigmaView theView;
    private final Cipher theModel;
    private String location;

    public EnigmaController(EnigmaView theView, Cipher theModel) {
        this.theView = theView;
        this.theModel = theModel;
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
                        int[][] one;
                        int[][] two;
                        int[][] nfo;
                        String fout;
                        one = formatStrToInt(Entext); //is the formatted plaintext
                        two = formatStrToInt(key); //is formatted key
                        nfo = theModel.Encipher(one, two);
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
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public String formatIntToStr(int[][] nfo) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        class DecryptListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                //will run if the decrypt button is pressed
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
                        nfo = theModel.decipher(one, two);
                        fout = formatIntToStr(nfo);
                        theView.setDecryptTextOutput(fout);
                    }
                } catch (Exception a) {
                    a.getMessage();
                }
                // theView.setentext(outstring);

            }
        }
    }
