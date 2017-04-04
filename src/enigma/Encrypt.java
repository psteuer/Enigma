/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.Arrays;
import static enigma.Cipher.NR;

/**
 *
 * @author Paul
 */
public class Encrypt extends Cipher {

    public int[][] Encipher(int[][] in, int[][] keyin) {
        int[][] state = in;
        int[][] key = keyin;
        int round = 0;
        int[][] expKey = new int[4][44]; //total of 176 bytes, 4 columns- each column a "word", 44 "words"

        expKey = KeyScheduler(key);
        state = AddRoundKey(state, expKey, round);
        for (round = 1; round < NR; round++) {
            state = SubBytes(state);
            state = myShiftRows(state);
            state = MixColumns(state);
            state = AddRoundKey(state, expKey, round);
        }
        state = SubBytes(state);
        state = myShiftRows(state);
        state = AddRoundKey(state, expKey, round);

        System.out.println("AND THE FINAL OUT COME IS...... \n");
        hexprint(state);
        return state;
    }

    /*
    INPUT: int[][] state
    OUTPUT: int[][] state
    Performes linear transofrmation on state
     */
    public int[][] MixColumns(int[][] state) {
        int[][] temp = new int[4][4];

        for (int c = 0; c < 4; c++) {
            temp[0][c] = MULT2[state[0][c]] ^ MULT3[state[1][c]] ^ state[2][c] ^ state[3][c];
            temp[1][c] = state[0][c] ^ MULT2[state[1][c]] ^ MULT3[state[2][c]] ^ state[3][c];
            temp[2][c] = state[0][c] ^ state[1][c] ^ MULT2[state[2][c]] ^ MULT3[state[3][c]];
            temp[3][c] = MULT3[state[0][c]] ^ state[1][c] ^ state[2][c] ^ MULT2[state[3][c]];
        }
        state = temp;
        return state;
    }

    /*
    INPUT: int[][] state
    OUTPUT: int[][] state
    NOTES: each entry substitued with corrisponding s-box entry
    For instance: 0x6E is substituted by entry of s-box in row 6, column E
     */
    public int[][] SubBytes(int[][] state) {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < NB; col++) {
                //break state apart into 2 bytes, use each byte for row/column lookup
                int e = state[row][col] & 0x0F;  //works for E
                int c = (state[row][col] >> 4) & 0x0F; //works for 6?
                state[row][col] = SBOX[c][e];
            }
        }
        return state;
    }

    /*
    INPUT: 2D array state array
    OUTPUT: 2D State array
    Shifts rows 2,3,4 by offsets of 1,2,3 respectively
    Calls the shiftleft function
     */
    public int[][] myShiftRows(int[][] state) {
        for (int r = 1; r < 4; r++) { //skip the first row  
            System.arraycopy(shiftleft(state[r], r), 0, state[r], 0, 4);
        }
        return state;
    }
    /*
    INPUT: int[] array , int off 
    OUTPUT: array
    Takes 1D array and shifts the rows to the LEFT by int off
     */

}
