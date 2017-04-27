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
public class Context {

    private keySize size;

    public Context() {
        size = null;
    }

    public void setSize(keySize size) {
        this.size = size;
    }

    public keySize getKeySize() {
        return size;
    }
}
