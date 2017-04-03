package enigma;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLClassLoader;
import javax.imageio.ImageIO;
import javax.swing.UIManager.LookAndFeelInfo;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

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
        Encrypt encrypt = new Encrypt();
        Decrypt decrypt = new Decrypt();
        EnigmaController thecontroller = new EnigmaController(theView, encrypt, decrypt);
       
        
        Result result = JUnitCore.runClasses(enigma.Tester.class);
         for(Failure failure : result.getFailures()){
             System.out.println(failure.toString());
         }
        
        
        //background https://uigradients.com/# love couple
        
        
    }

}
