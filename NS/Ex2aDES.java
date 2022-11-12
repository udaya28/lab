package NS;

// ALGORITHM:

// STEP-1: Read the 64-bit plain text.
// STEP-2: Split it into two 32-bit blocks and store it in two different arrays.
// STEP-3: Perform XOR operation between these two arrays.
// STEP-4: The output obtained is stored as the second 32-bit sequence and the original second 32-bit sequence forms the first part.
// STEP-5: Thus the encrypted 64-bit cipher text is obtained in this way. Repeat the same process for the remaining plain text characters.

import javax.swing.*;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;

public class Ex2aDES {
    byte[] skey = new byte[1000];
    String skeyString;
    static byte[] raw;
    String inputMessage, encryptedData, decryptedMessage;

    public Ex2aDES() {
        try {
            generateSymmetricKey();
            inputMessage = JOptionPane.showInputDialog(null, "Enter message to encrypt");
            byte[] ibyte = inputMessage.getBytes();
            byte[] ebyte = encrypt(raw, ibyte);
            String encryptedData = new String(ebyte);
            System.out.println("Encrypted message " + encryptedData);
            JOptionPane.showMessageDialog(null, "Encrypted Data " + "\n" + encryptedData);
            byte[] dbyte = decrypt(raw, ebyte);
            String decryptedMessage = new String(dbyte);
            System.out.println("Decrypted message " + decryptedMessage);
            JOptionPane.showMessageDialog(null, "Decrypted Data " + "\n" + decryptedMessage);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void generateSymmetricKey() {
        try {
            Random r = new Random();
            int num = r.nextInt(10000);
            String knum = String.valueOf(num);
            byte[] knumb = knum.getBytes();
            skey = getRawKey(knumb);
            skeyString = new String(skey);
            System.out.println("DES Symmetric key = " + skeyString);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static byte[] getRawKey(byte[] seed) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("DES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(seed);
        kgen.init(56, sr);
        SecretKey skey = kgen.generateKey();
        raw = skey.getEncoded();
        return raw;
    }

    private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(clear);
        return encrypted;
    }

    private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }

    public static void main(String args[]) {
        Ex2aDES des = new Ex2aDES();
    }
}

// OUTPUT
// DES Symmetric key = @?º??1Ös
// Encrypted message Pé?yö?
// Decrypted message hello