/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

/**
 *
 * @author Paul
 */
public class OneTwentyEight implements keySize {

    public void set(Context context) {
        context.setSize(this);
    }
    
    public int getNB(){
        return 4;
    }
    public int getNK(){
        return 4;
    }
    public int getNR(){
        return 10;
    }
    
}
