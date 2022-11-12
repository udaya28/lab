package NS;

// ALGORITHM:

// STEP-1: Read the 256-bit key values.
// STEP-2: Divide into five equal-sized blocks named A, B, C, D and E.
// STEP-3: The blocks B, C and D are passed to the function F.
// STEP-4: The resultant value is permuted with block E.
// STEP-5: The block A is shifted right by ‘s’ times and permuted with the result of step-4.

// STEP-6: Then it is permuted with a weight value and then with some other key pair and taken as the first block.
// STEP-7: Block A is taken as the second block and the block B is shifted by ‘s’ times and taken as the third block.
// STEP-8: The blocks C and D are taken as the block D and E for the final output.

import java.security.*;

public class Ex2eSHA1 {
    public static void main(String[] a) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            System.out.println("Message digest object info: ");
            System.out.println(" Algorithm = " + md.getAlgorithm());
            System.out.println(" Provider = " + md.getProvider());
            System.out.println(" ToString = " + md.toString());
            String input = "";
            md.update(input.getBytes());
            byte[] output = md.digest();
            System.out.println();
            System.out.println("SHA1(\"" + input + "\") =" + bytesToHex(output));
            input = "abc";
            md.update(input.getBytes());
            output = md.digest();
            System.out.println();
            System.out.println("SHA1(\"" + input + "\") = "
                    + bytesToHex(output));
            input = "abcdefghijklmnopqrstuvwxyz";
            md.update(input.getBytes());
            output = md.digest();
            System.out.println();
            System.out.println("SHA1(\"" + input + "\") = "
                    + bytesToHex(output));
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public static String bytesToHex(byte[] b) {
        char hexDigit[] = { '0', '1', '2', '3', '4', '5', '6',
                '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        StringBuffer buf = new StringBuffer();
        for (int j = 0; j < b.length; j++) {

            buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
            buf.append(hexDigit[b[j] & 0x0f]);
        }
        return buf.toString();
    }
}

// OUTPUT
// Message digest object info:
// Algorithm = SHA1
// Provider = SUN version 14
// ToString = SHA1 Message Digest from SUN, <initialized>

// SHA1("") =DA39A3EE5E6B4B0D3255BFEF95601890AFD80709

// SHA1("abc") = A9993E364706816ABA3E25717850C26C9CD0D89D

// SHA1("abcdefghijklmnopqrstuvwxyz") = 32D10C7B8CF96570CA04CE37F2A19D84240D3A89
