/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @author Paul
 */
public class KeyRand extends EnigmaController implements ActionListener {

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
