
package enigma;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author tuf67096
 */
public class Enigma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EnigmaView theView = new EnigmaView();
        Cipher cipher = new Cipher();
        EnigmaController thecontroller = new EnigmaController(theView,cipher);
        theView.setVisible(true);
        
    }
    
}
