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
 * @author psteu_000
 */
//This is the Controller for the MVC model
public class EnigmaController {
    private EnigmaView theView;
    private Cipher theModel;
    
    public EnigmaController(EnigmaView theView, Cipher theModel) {
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addEncryptListener(new EncryptListener());
    }   
    class EncryptListener implements ActionListener{
        public void actionPerformed(ActionEvent e){ 
            //Gets the key and the plaintext
            String key = "";
            String Entext = "";
            //put in try catch block
            key = theView.getkeytext();
            System.out.println(key);   ///testing
            theView.setentext("WOrking?");
            Entext = theView.getentext();
            theModel.Encipher(Entext, key);
    }
    class DecryptListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //will run if the decrypt button is pressed
            System.out.println("HELLO?");
            String key = "";
            String Detext = "";
            key = theView.getkeytext();
            Detext = theView.getdetext();
            theModel.decipher(Detext, key);
            
        }
    
        
    }
}
}