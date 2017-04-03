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

    int[][] SecondKeyRound = {{0xe2, 0x91, 0xB1, 0xD6}, {0x32, 0x12, 0x59, 0x79}, {0xFC, 0x91, 0xe4, 0xA2}, {0xf1, 0x88, 0xe6, 0x93}};
    int[][] FirstRoundState = {{0xBA, 0x84, 0xE8, 0x1b}, {0x75, 0xA4, 0x8D, 0x40}, {0xF4, 0x8D, 0x06, 0x7D}, {0x7A, 0x32, 0x0E, 0x5D}};
    int[][] SecondKeyRoundANDFirstRoundStateYEILD = {{0x58, 0x15, 0x59, 0xCD}, {0x47, 0xb6, 0xD4, 0x3}, {0x08, 0x1c, 0xe2, 0xdf}, {0x8b, 0xba, 0xe8, 0xce}};

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

    int[][] PlainText = {{0x54, 0x77, 0x6F, 0x20}, {0x4F, 0x6E, 0x65, 0x20}, {0x4E, 0x69, 0x6E, 0x65}, {0x20, 0x54, 0x77, 0x6F}};
    int[][] CipherText = {{0x29, 0xC3, 0x50, 0x5F}, {0x57, 0x14, 0x20, 0xF6}, {0x40, 0x22, 0x99, 0xB3}, {0x1A, 0x02, 0xD7, 0x3A}};

    String str = "Thats my Kung Fu";
    String strShort = "Thats m";

    // int[][] = FullKeyTestVector = {0x00, 0x00, 0x00, 0x00, 0x62,0x62,0x62,0x62,0x620x62	0x9B0xF99B0x9BF90xF9	0x900x69F20xF20B0x0B	0xEE0x87750x757E0x7E	0x7F0xF88D0x8DF30xF3	0xEC0x14990x996A0x6A	0x210x35AC0xACC60xC6	0x0E0x3B970x97510x51	0xB10x8A1D0x1D4C0x4C	0xB40x3E230x236F0x6F
    //{0x00, 0x00, 0x00, 0x00}0x630x63630x63630x63	0x980xFB980x98FB0xFB	0x970x6CF40xF40F0x0F	0x060x6A9E0x9E910x91	0x2E0x44DA0xDA4B0x4B	0x610x25FF0xFFB40xB4	0x750x50AF0xAF1B0x1B	0xF90xA9060x061D0x1D	0xD40x7D7B0x7B660x66	0xEF0x92E90xE98F0x8F
    //{0x00, 0x00, 0x00, 0x00}0x630x63630x63630x63	0x980xFB980x98FB0xFB	0x340xCF570x57AC0xAC	0xDA0x15420x42EE0xEE	0x2B0x3E7C0x7C920x92	0x4B0x75090x099B0x9B	0x170x626B0x6BF00xF0	0x030x610A0x0AFA0xFA	0xD80xB9B30xB3490x49	0x5B0xE2510x51180x18
    //{0x00, 0x00, 0x00, 0x00}0x630x63630x63630x63	0xC90xAAC90xC9AA0xAA	0x500xFA330x33990x99	0x7B0x81B20xB22B0x2B	0x880x09BB0xBB900x90	0x850x8C370x37A70xA7	0x870x0B3C0x3C9B0x9B	0x330x38040x049F0x9F	0xE20xDADE0xDE410x41	0xCB0x11CF0xCF8E0x8E};
    @Test
    public void testShiftRows() {
        Assert.assertArrayEquals(shiftLeftAns, etest.myShiftRows(shiftTest));//good
    }

    @Test
    public void testinvShiftRows() {
        Assert.assertArrayEquals(shiftTest, dtest.myInvShiftRows(shiftLeftAns)); //good
    }

    @Test
    public void testAddRoundKey() {
        Assert.assertArrayEquals(RooundKeyans, etest.AddRoundKey(stateTest, keyTest, 0)); //error
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
        Assert.assertArrayEquals(key, control.format("Thats my Kung Fu", "Key")); //key good
    }

    @Test
    public void TestFormatStrToInt() {
        // Assert.assertArrayEquals(key, control.formatStrToInt("Thats my Kung Fu")); //good
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
    public void TestformatIntToStr() {
        Assert.assertEquals("Thats my Kung Fu", control.formatIntToStr(key));
    }

    @Test
    public void TestEncrypt() {
        // Assert.assertArrayEquals(CipherText, etest.Encipher(PlainText, key));//good
    }

    @Test
    public void TestDecrypt() {
        // Assert.assertArrayEquals(PlainText, dtest.decipher(CipherText, key));//good
    }

    @Test
    public void testRightShift() {
        int[] rightshiftIn = {0x2F, 0x93, 0x92, 0xC0};
        int[] rightshiftOUT = {0xC0, 0x2F, 0x93, 0x92};
        Assert.assertArrayEquals(rightshiftOUT, dtest.shiftRight(rightshiftIn, 1));//good
    }

    @Test
    public void testLeftShift() {
        int[] rightshiftIn = {0x2F, 0x93, 0x92, 0xC0};
        int[] rightshiftOUT = {0xC0, 0x2F, 0x93, 0x92};
        Assert.assertArrayEquals(rightshiftIn, dtest.shiftRight(rightshiftOUT, 3));//good
    }

    @Test
    public void testKeyCore() {
        int[] temp = {0x09, 0xcf, 0x4f, 0x3c};
        int[] ans = {0x8b, 0x84, 0xeb, 0x01};
        int rconplace = 1;
        Assert.assertArrayEquals(ans, etest.KeyCore(temp, rconplace));//good
    }

    @Test
    public void secondKeyCoreTest() {
        int[] temp = {0x2a, 0x6c, 0x76, 0x05};
        int[] ans = {0x52, 0x38, 0x6b, 0xe5};
        int rconplace = 2;
        Assert.assertArrayEquals(ans, dtest.KeyCore(temp, rconplace));//good
    }

    @Test
    public void SecondAddRoundKeyTest() {
        int[][] SecondKeyRound = {{0xe2, 0x91, 0xB1, 0xD6}, {0x32, 0x12, 0x59, 0x79}, {0xFC, 0x91, 0xe4, 0xA2}, {0xf1, 0x88, 0xe6, 0x93}};
        int[][] FirstRoundState = {{0xBA, 0x84, 0xE8, 0x1b}, {0x75, 0xA4, 0x8D, 0x40}, {0xF4, 0x8D, 0x06, 0x7D}, {0x7A, 0x32, 0x0E, 0x5D}};
        int[][] SecondKeyRoundANDFirstRoundStateYEILD = {{0x58, 0x15, 0x59, 0xCD}, {0x47, 0xb6, 0xD4, 0x3}, {0x08, 0x1c, 0xe2, 0xdf}, {0x8b, 0xba, 0xe8, 0xce}};
        Assert.assertArrayEquals(SecondKeyRoundANDFirstRoundStateYEILD, etest.AddRoundKey(FirstRoundState, SecondKeyRound, 1)); 

    }

}
