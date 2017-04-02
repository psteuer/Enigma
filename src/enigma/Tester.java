package enigma;

import org.junit.Assert;

import org.junit.Test;

/**
 * Testing Class for Cipher functions
 *
 */
public class Tester {

    Encrypt etest = new Encrypt();
    Decrypt dtest = new Decrypt();
    EnigmaView theView = new EnigmaView();
    Encrypt encrypt = new Encrypt();
    Decrypt decrypt = new Decrypt();
    EnigmaController control = new EnigmaController(theView, encrypt, decrypt);

    //Test Vectors
    int[][] shiftTest = {{0x63, 0xEB, 0x9F, 0xA0}, {0xC0, 0x2F, 0x93, 0x92}, {0xAB, 0x30, 0xAF, 0xC7}, {0x20, 0xCB, 0x2B, 0xA2}};
    int[][] shiftLeftAns = {{0x63, 0xEB, 0x9F, 0xA0}, {0x2F, 0x93, 0x92, 0xC0}, {0xAF, 0xC7, 0xAB, 0x30}, {0xA2, 0x20, 0xCB, 0x2B}};

    int[][] stateTest = {{0x54, 0x4F, 0x4E, 0x20}, {0x77, 0x6E, 0x69, 0x54}, {0x6F, 0x65, 0x6E, 0x77}, {0x20, 0x20, 0x65, 0x6F}};
    int[][] keyTest = {{0x54, 0x73, 0x20, 0x67}, {0x68, 0x20, 0x4B, 0x20}, {0x61, 0x6D, 0x75, 0x46}, {0x74, 0x079, 0x6E, 0x75}};
    int[][] RooundKeyans = {{0x00, 0x3C, 0x6E, 0x47}, {0x1F, 0x4E, 0x22, 0x74}, {0x0E, 0x08, 0x1B, 0x31}, {0x54, 0x59, 0x0B, 0x1A}};

    int[][] subbytesAns = {{0x63, 0xEB, 0x9F, 0xA0}, {0xC0, 0x2F, 0x93, 0x92}, {0xAB, 0x30, 0xAF, 0xC7}, {0x20, 0xCB, 0x2B, 0xA2}};

    int[][] MixInput = {{0x63, 0xEB, 0x9F, 0xA0}, {0x2F, 0x93, 0x92, 0xC0}, {0xAF, 0xC7, 0xAB, 0x30}, {0xA2, 0x20, 0xCB, 0x2B}};
    int[][] MixOutput = {{0xBA, 0x84, 0xE8, 0x1B}, {0x75, 0xA4, 0x8D, 0x40}, {0xF4, 0x8D, 0x06, 0x7D}, {0x7A, 0x32, 0x0E, 0x5D}};

    int[][] keyIn = {{0x2b, 0x7e, 0x15, 0x16}, {0x28, 0xae, 0xd2, 0xa6}, {0xab, 0xf7, 0x15, 0x88}, {0x09, 0xcf, 0x4f, 0x3c}};

    int[][] key = {{0x54, 0x68, 0x61, 0x74}, {0x73, 0x20, 0x6D, 0x79}, {0x20, 0x4B, 0x75, 0x6E}, {0x67, 0x20, 0x46, 0x75}};
    int[][] stateKeyInput = {{0x54, 0x4F, 0x4E, 0x20}, {0x77, 0x6E, 0x69, 0x54}, {0x6F, 0x65, 0x6E, 0x77}, {0x20, 0x020, 0x65, 0x6F}};

    String str = "Thats my Kung Fu";
    String strShort = "Thats m";

    @Test
    public void testShiftRows() {
        System.out.println("Reach the Tester 1");
        Assert.assertArrayEquals(shiftLeftAns, etest.myShiftRows(shiftTest));//good
    }

    @Test
    public void testinvShiftRows() {
        Assert.assertArrayEquals(shiftTest, dtest.myInvShiftRows(shiftLeftAns)); //good
    }

    @Test
    public void testAddRoundKey() {
        Assert.assertArrayEquals(RooundKeyans, etest.AddRoundKey(stateTest, keyTest, 0)); //good
    }

    @Test
    public void testSubBytes() {
        Assert.assertArrayEquals(subbytesAns, etest.SubBytes(RooundKeyans)); //good
    }

    @Test
    public void testinvSubBytes() {
        Assert.assertArrayEquals(RooundKeyans, dtest.invSubBytes(subbytesAns)); //good
    }

    @Test
    public void testMixColumns() {
        Assert.assertArrayEquals(MixOutput, etest.MixColumns(MixInput)); //good
    }

    @Test
    public void testInvMixColumns() {
        Assert.assertArrayEquals(MixInput, dtest.InvMixColumns(MixOutput));//good
    }

    @Test
    public void format() {
        Assert.assertArrayEquals(key, control.format("Thats my Kung Fu", 1)); //key good
    }

    @Test
    public void TestFormatStrToInt() {
        Assert.assertArrayEquals(key, control.formatStrToInt("Thats my Kung Fu")); //good
    }

    @Test
    public void testPadding() {
        Assert.assertEquals(str.length(), control.padding(strShort).length());
    }

    @Test
    public void testRand() {
        Assert.assertEquals(16, theView.getkeytext().length());
    }
    @Test
    public void TestformatIntToStr(){
        Assert.assertEquals("Thats my Kung Fu" , control.formatIntToStr(key) );
    }
}
