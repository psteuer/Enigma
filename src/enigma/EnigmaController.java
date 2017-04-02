/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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
        theView.btnEnableDisable(false);

        theView.addEncryptListener(new EncryptListener());
        theView.addDecryptListener(new DecryptListener());
        theView.addFileSelector(new FileSelector());
        theView.addGoEncryptFile(new EncryptFile());
        theView.addGoDecryptFile(new DecryptFile());
        theView.addRand(new KeyRand());
    }

    class KeyRand implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //split this up into another class?
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
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(theView);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                location = selectedFile.getAbsolutePath();
                theView.setIsFileText(location);
                theView.btnEnableDisable(true);
                //Also set filter to only text files 
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
                nfo = EncryptModel.Encipher(format(Entext, 2), format(key, 1));

                //Sets the formatted output to textbox
                theView.setEncryptTextOutput(formatIntToStr(nfo));

            } catch (Exception abc) {
                abc.getMessage();
            }

        }

    }

    /*
    INPUT: String input - to convert, type: 1 is Key, 2 is Input
     */
    public int[][] format(String in, int type) {
        String w;
        int[][] formattedIn; //formatted entext
        if (type == 1) {
            w = " Key ";
        } else {
            w = " Input ";
        }
        //check if input is too big
        if (in.length() > 16) { //16 is 1 byte so 128 bits
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Error: Please enter a" + w + "value less than 128 bits \n ie. Thats my Kung Fu", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //check if padding is needed
        if (in.length() < 16) {
            in = padding(in);
        }
        formattedIn = formatStrToInt(in); //is the formatted plaintext
        return formattedIn;
    }

    public String padding(String key) {
        int len = key.length();
        String space = new String(new char[16 - len]).replace('\0', ' ');
        key = key + space;
        return key;
    }

    public int[][] formatStrToInt(String Entext) {
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
                state[c][r] = (int) ans[count];
                count++;
            }
        }
        return state;
    }

    public String formatIntToStr(int[][] nfo) {
        char[] n = new char[16];
        int count = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                n[count] = (char) nfo[r][c];
                count++;
            }
        }
        String out = new String(n);
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

    class DecryptListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String key;
            String Detext;
            try {
                key = theView.getkeytext();
                Detext = theView.getdetext();

                int[][] nfo;
                nfo = DecryptModel.decipher(format(Detext, 2), format(key, 1));
                theView.setDecryptTextOutput(formatIntToStr(nfo));

            } catch (Exception abc) {
                abc.getMessage();
            }

        }
    }
}
