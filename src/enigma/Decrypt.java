/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.Arrays;

/**
 *
 * @author Paul
 */
public class Decrypt extends Cipher {

    public int[][] decipher(int[][] in, int[][] keyin) {
        //Decryption Algorithm

        int[][] state = in;
        int[][] key = keyin;
        int[][] expKey = KeyScheduler(key);

        int round = 11;
        state = AddRoundKey(state, expKey, round);
        for (round = NR - 1; round >= 1; round--) {
            state = myInvShiftRows(state);
            state = invSubBytes(state);
            state = AddRoundKey(state, expKey, round);
            state = InvMixColumns(state);
        }
        myInvShiftRows(state);
        invSubBytes(state);
        AddRoundKey(state, expKey, round);

        return state;
    }

    /*
    INPUT: int[][] state
    OUTPUT: int[][] state
    Performes linear transofrmation on state
     */
    //NOTESTED_______________________________________________
    public int[][] InvMixColumns(int[][] state) {
        int[][] temp = new int[4][4];

        for (int c = 0; c < 4; c++) {
            temp[0][c] = MULT14[state[0][c]] ^ MULT11[state[1][c]] ^ MULT13[state[2][c]] ^ MULT9[state[3][c]];
            temp[1][c] = MULT9[state[0][c]] ^ MULT14[state[1][c]] ^ MULT11[state[2][c]] ^ MULT13[state[3][c]];
            temp[2][c] = MULT13[state[0][c]] ^ MULT9[state[1][c]] ^ MULT14[state[2][c]] ^ MULT11[state[3][c]];
            temp[3][c] = MULT11[state[0][c]] ^ MULT13[state[1][c]] ^ MULT9[state[2][c]] ^ MULT14[state[3][c]];
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
    public int[][] invSubBytes(int[][] state) {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < NB; col++) {
                //break state apart into 2 bytes, use each byte for row/column lookup
                int e = state[row][col] & 0x0F;  //works for E
                int c = (state[row][col] >> 4) & 0x0F; //works for 6
                state[row][col] = INV_SBOX[c][e];
            }
        }

        return state;
    }

    /*
    INPUT: 2D array state array
    OUTPUT: 2D State array
    Shifts rows 2,3,4 by offsets of 1,2,3 respectively
    Calls the rightshift function
     */
    public int[][] myInvShiftRows(int[][] state) {
        for (int r = 1; r < 4; r++) {
            System.arraycopy(shiftRight(state[r], r), 0, state[r], 0, 4);
        }
        //System.out.println("Inv ShiftRows state: " + Arrays.deepToString(state));
        return state;
    }

    /*
    INPUT: int[] array , int off 
    OUTPUT: array
    Takes 1D array and shifts the rows to the Right by int off
     */
    public int[] shiftRight(int[] row, int off) {

        int[] temp = new int[off];
        for (int i = 0; i < off; i++) {
            temp[i] = row[row.length - off + i];
        }
        System.arraycopy(row, 0, row, off, row.length - off);
        for (int a = 0; a < off; a++) {
            row[a] = temp[a];
        }
        return row;
    }

}
