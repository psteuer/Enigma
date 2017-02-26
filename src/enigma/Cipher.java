
package enigma;
//TODO define Nb and Nr both 4
/**
 *
 * @author tuf67096
 */
public class Cipher {
public static final int Nb = 4;
public static final int Nr = 4;
    void cipher(byte[] in, byte[] out, byte[] key){
        //in is the input plain text
        //out is the output in cipher text
        //key is the expanded key of size 4*Nb*(Nb+1)
        byte[][] state = new byte[4][Nb];  ///Nb will always be size 4
       // state = in; 
        
        //AddRoundKey(state, word, Nb-1);
        for(int round = 1; round < Nr; round++){
         //   SubBytes(state);
          //  ShiftRows(state);
           // MixColumns(state);
            //AddRoundKey(state, word, round*Nb, (round+1)*Nb - 1);
                 
        }
        
        
    
    } 
}
