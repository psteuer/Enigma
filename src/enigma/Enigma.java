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
        Cipher cipher = new Cipher();
        EnigmaController thecontroller = new EnigmaController(theView, cipher);
       
        /*
        Result result = JUnitCore.runClasses(Enigma.Tester.class);
         for(Failure failure : result.getFailures()){
             System.out.println(failure.toString());
         }
        
        */
        //background https://uigradients.com/# love couple
        
        
    }

}
