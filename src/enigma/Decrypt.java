package enigma;

/**
 *
 * @author Paul Extends Cipher, this is the decrypt algorithm
 */
public class Decrypt extends Cipher {

    /**
     * Decrypt Function for AES
     *
     * @param state
     * @param key
     * @return state, decrypted
     */
    public int[][] decipher(int[][] state, int[][] key) {

        int[][] expKey = KeyScheduler(key);
        int round = NR;
        state = AddRoundKey(state, expKey, round);

        for (round = NR - 1; round > 0; round--) {
            state = myInvShiftRows(state);
            state = invSubBytes(state);
            state = AddRoundKey(state, expKey, round);
            state = InvMixColumns(state);
        }

        myInvShiftRows(state);
        invSubBytes(state);
        AddRoundKey(state, expKey, round);
        System.out.println("THE FINAL DECRYPTION OUTCOME IS...");
        hexprint(state);
        return state;
    }

    /**
     * Performs linear transformation on state Look up tables are in Cipher, for
     * doing GF(2^8) multiplication
     *
     * @param state
     * @return ModifiedState, changed state matrix
     */
    public int[][] InvMixColumns(int[][] state) {

        int[][] ModifiedState = new int[4][4];

        for (int c = 0; c < 4; c++) {
            ModifiedState[0][c] = MULT14[state[0][c]] ^ MULT11[state[1][c]] ^ MULT13[state[2][c]] ^ MULT9[state[3][c]];
            ModifiedState[1][c] = MULT9[state[0][c]] ^ MULT14[state[1][c]] ^ MULT11[state[2][c]] ^ MULT13[state[3][c]];
            ModifiedState[2][c] = MULT13[state[0][c]] ^ MULT9[state[1][c]] ^ MULT14[state[2][c]] ^ MULT11[state[3][c]];
            ModifiedState[3][c] = MULT11[state[0][c]] ^ MULT13[state[1][c]] ^ MULT9[state[2][c]] ^ MULT14[state[3][c]];
        }

        return ModifiedState;
    }

    /**
     * Uses INV_SBOX lookup table on all elements in state For instance: 0x6E is
     * substituted by entry of s-box in row 6, column E
     *
     * @param state
     * @return state, this is the modified state
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

    /**
     * Shifts rows to the right, calls shiftRight function Shifts rows 2,3,4 by
     * offsets of 1,2,3 respectively
     *
     * @param state
     * @return state
     */
    public int[][] myInvShiftRows(int[][] state) {
        for (int r = 1; r < 4; r++) {
            System.arraycopy(shiftRight(state[r], r), 0, state[r], 0, 4);
        }
        return state;
    }

    /**
     * Shifts row to the right based on offset
     *
     * @param row
     * @param offset, amount you want to shift row
     * @return row, shifted row
     */
    public int[] shiftRight(int[] row, int offset) {

        int[] rowBeginning = new int[offset];
        for (int i = 0; i < offset; i++) {
            rowBeginning[i] = row[row.length - offset + i];
        }
        System.arraycopy(row, 0, row, offset, row.length - offset);
        System.arraycopy(rowBeginning, 0, row, 0, offset);
        return row;
    }

}
