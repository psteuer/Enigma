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
public class Encrypt extends Cipher {

    public Encrypt(int nb, int nr, int nk) {
        this.NB = nb;
        this.NR = nr;
        this.NK = nk;
        this.NW = nb * (nr + 1);
        this.NWB = 4 * nb * (nr + 1);
    }

    /**
     * Encryption algorithm
     *
     * @param state
     * @param key
     * @return state - new encrypted state
     */
    public int[][] Encipher(int[][] state, int[][] key) {
 
        int round = 0;
        int[][] expKey = KeyScheduler(key);
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

        System.out.println("AND THE FINAL ENCRYPTION OUTCOME IS...... \n");
        hexprint(state);
        return state;
    }

    /**
     * Performs GF(2^8) multiplication on each element by lookup table Performs
     * linear transformation on state
     *
     * @param state
     * @return state
     */
    public int[][] MixColumns(int[][] state) {
        int[][] ModifiedState = new int[4][4];

        for (int c = 0; c < 4; c++) {
            ModifiedState[0][c] = MULT2[state[0][c]] ^ MULT3[state[1][c]] ^ state[2][c] ^ state[3][c];
            ModifiedState[1][c] = state[0][c] ^ MULT2[state[1][c]] ^ MULT3[state[2][c]] ^ state[3][c];
            ModifiedState[2][c] = state[0][c] ^ state[1][c] ^ MULT2[state[2][c]] ^ MULT3[state[3][c]];
            ModifiedState[3][c] = MULT3[state[0][c]] ^ state[1][c] ^ state[2][c] ^ MULT2[state[3][c]];
        }
        state = ModifiedState;
        return state;
    }

    /**
     * each entry substituted with s-box entry For instance: 0x6E is substituted
     * by entry of s-box in row 6, column E
     *
     * @param state
     * @return state, modified state
     */
    public int[][] SubBytes(int[][] state) {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < NB; col++) {
                //break state apart into 2 bytes, use each byte for row/column lookup
                int e = state[row][col] & 0x0F;
                int c = (state[row][col] >> 4) & 0x0F;
                state[row][col] = SBOX[c][e];
            }
        }
        return state;
    }

    /**
     * Shifts rows 2,3,4 by offsets of 1,2,3 respectively Calls the shiftleft()
     * function in Cipher
     *
     * @param state
     * @return state
     */
    public int[][] myShiftRows(int[][] state) {
        for (int r = 1; r < 4; r++) { //skip the first row  
            System.arraycopy(shiftleft(state[r], r), 0, state[r], 0, 4);
        }
        return state;
    }

}
