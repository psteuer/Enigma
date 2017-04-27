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
public class OneNineTwo implements keySize {
    public void set(Context context) {
        context.setSize(this);
    }
    
    public int getNB(){
        return 4;
    }
    public int getNK(){
        return 6;
    }
    public int getNR(){
        return 12;
    }
}
