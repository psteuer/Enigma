/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Paul
 */
class EncryptListener extends EnigmaController implements ActionListener {

    public EncryptListener(EnigmaView theView, Encrypt WEncryptModel, Decrypt DecryptModel) {
        super(theView, WEncryptModel, DecryptModel);
        //theView.addEncryptListener(new EncryptListener());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("HIIIIIIIIIIIII from the listener");

        String key;
        String Entext;
        try {
            key = theView.getkeytext();
            Entext = theView.getentext();
            int[][] nfo;
           // nfo = EncryptModel.Encipher(format(Entext, "PlainText"), format(key, "Key"));
            //Sets the formatted output to textbox
           // theView.setEncryptTextOutput(formatIntToStr(nfo));

        } catch (Exception abc) {
            abc.getMessage();
        }

    }

}

/*
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

 */
