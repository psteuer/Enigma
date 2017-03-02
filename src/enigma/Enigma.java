
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
        System.out.println("Hello");
        String encryptText = "";
        String decryptText = "";
        String keyText = "";
        JFrameWindow gui = new JFrameWindow();
        encryptText = gui.getentext();
        decryptText = gui.getdetext();
        keyText = gui.getkeytext();
        
        Cipher cipher = new Cipher();
        
        
        
    }
    
}
