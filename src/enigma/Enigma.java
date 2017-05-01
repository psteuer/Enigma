package enigma;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Main class for Enigma, creates instance of MVC and for testing
 *
 * @author tuf67096
 */
public class Enigma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // EnigmaView theView = new EnigmaView();
        //Encrypt encrypt = new Encrypt();
        // Decrypt decrypt = new Decrypt();
        // EnigmaController thecontroller = new EnigmaController(theView, encrypt, decrypt);
        EnigmaController thecontroller = new EnigmaController();

        //Result result = JUnitCore.runClasses(enigma.Tester.class);
        //for (Failure failure : result.getFailures()) {
        //    System.out.println(failure.toString());
        //}

    }

}
