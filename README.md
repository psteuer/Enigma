Enigma + By Paul Steuer + 3238 Software Design
________________________________________________________________________________________________________
SYNOPSIS:
________________________________________________________________________________________________________
This program is an implementation of the Advanced Encryption Standard (AES) 128 bit encryption and decryption algorithm. 
The two main parts to the algorithm are the encryption and decryption.
The Encryption algorithm takes in plaintext and outputs ciphertext in base64. (Max length of 16 bytes)
The Decryption algorithm takes in ciphertext in base64 and outputs it to plaintext. Must be 24 bytes long.
The key is shared between the encrypt and decrypt algorithms and must be 16 bytes long. (Max length of 16 bytes)
________________________________________________________________________________________________________
HOW TO:
________________________________________________________________________________________________________
Steps:
1. Clone the program to your IDE (Preferably NetBeans & Windows 10)
2. Run
3. Type in a key, this is any text but must be 16 bytes (128 bits or 16 chars)
4. ENCRYPT: Enter plaintext - this can be any text 16 bytes long (128 bits or 16 chars)
5. DECRYPT: Enter ciphertext in base64 - must be 24 bytes long (192 bits or 24 chars)
6. Click Decrypt or Encrypt
 ________________________________________________________________________________________________________
To Encrypt a file:
1. Click "Select file" and select a file, this must be a text file. (Ends in .txt) This can be any text. 
2. Click Encrypt
3. The Encrypted output file can be found in the same directory with "Encrypted" after your file name. 
________________________________________________________________________________________________________
To Decrypt a file:
1. Click "Select file" and select a file, this must be a text file. (Ends in .txt) This file must be encoded in base64
2. Click Decrypt
3. The Decrypted output file can be found in the same directory with "Decrypted" after your file name. 
________________________________________________________________________________________________________
ABOUT:
________________________________________________________________________________________________________
There are five main methods in the AES algorithm:
1. AddRoundKey() - This XOR's the state matrix to the key at a given round
2. MixColumns() - Performs linear transformation on the state matrix. Essentially multiplies each column using GF(2^8) math. 
3. SubBytes() -    Each entry in the state matrix is substituted with corresponding s-box entry
4. MyShiftRows() -  Shifts rows 2,3,4 by offsets of 1,2,3 respectively
5. KeySecheduler() -  algorithm which expands the 4x4 key matrix into a 4x44 matrix (for 128 bit encryption)
________________________________________________________________________________________________________
