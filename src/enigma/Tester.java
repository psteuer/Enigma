
package enigma;
import org.junit.Assert;

import org.junit.Test;
/**
 *Testing Class for Cipher functions
 * 
 */
public class Tester {

    Cipher ctest = new Cipher();
    int[][] shiftTest = {{0x63, 0xEB, 0x9F, 0xA0}, {0xC0, 0x2F, 0x93, 0x92}, {0xAB, 0x30, 0xAF, 0xC7}, {0x20, 0xCB, 0x2B, 0xA2}};
    int[][] shiftLeftAns = {{0x63, 0xEB, 0x9F, 0xA0}, {0x2F, 0x93, 0x92, 0xC0}, {0xAF, 0xC7, 0xAB, 0x30}, {0xA2, 0x20, 0xCB, 0x2B}};
    
    int[][] stateTest = {{0x54, 0x4F, 0x4E, 0x20}, {0x77, 0x6E, 0x69, 0x54}, {0x6F, 0x65, 0x6E, 0x77}, {0x20, 0x20, 0x65, 0x6F}};
    int[][] keyTest = {{0x54, 0x73, 0x20, 0x67}, {0x68, 0x20, 0x4B, 0x20}, {0x61, 0x6D, 0x75, 0x46}, {0x74, 0x079, 0x6E, 0x75}};
    int[][] RooundKeyans = {{0x00,0x3C,0x6E,0x47},{0x1F,0x4E,0x22,0x74},{0x0E,0x08,0x1B,0x31},{0x54,0x59,0x0B,0x1A}};
    
    int[][] subbytesAns = {{0x63,0xEB,0x9F,0xA0},{0xC0,0x2F,0x93,0x92},{0xAB,0x30,0xAF,0xC7},{0x20,0xCB,0x2B,0xA2}};
    
    int[][] MixOutput = {{0xBA,0x84,0xE8,0x1B},{0x75,0xA4,0x8D,0x40},{0xF4,0x8D,0x06,0x7D},{0x7A,0x32,0x0E,0x5D}};
    @Test
    public void testShiftRows(){
        System.out.println("Reach the Tester 1");
        Assert.assertArrayEquals(shiftLeftAns, ctest.myShiftRows(shiftTest));
    }
    
    @Test
    public void testinvShiftRows(){
       Assert.assertArrayEquals(shiftTest, ctest.myInvShiftRows(shiftLeftAns));
    }
    
    @Test
    public void testAddRoundKey(){
      Assert.assertArrayEquals(RooundKeyans, ctest.AddRoundKey(stateTest, keyTest));
    }
    
    @Test
    public void testSubBytes(){
        Assert.assertArrayEquals(subbytesAns, ctest.SubBytes(RooundKeyans));
    }
    @Test
    public void testinvSubBytes(){
        Assert.assertArrayEquals(RooundKeyans, ctest.SubBytes(subbytesAns));
    }
    @Test
    public void testMix(){
        Assert.assertArrayEquals(MixOutput, ctest.MixColumns(shiftLeftAns));
    }
}