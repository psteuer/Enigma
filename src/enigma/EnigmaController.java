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
    private JFrameWindow theView;
    private Cipher theModel;
    
    public EnigmaController(JFrameWindow theView, Cipher theModel) {
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addEncryptListener(new EncryptListener());
    }
    class EncryptListener implements ActionListener(){
        public void actionPerformed(ActionEvent e){
            //Gets the key and the Encryptdata
            //line 25 in example from http://www.newthinktank.com/2013/02/mvc-java-tutorial/
        }
    }
}