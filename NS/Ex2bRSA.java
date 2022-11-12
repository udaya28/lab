package NS;

// ALGORITHM:

// STEP-1: Select two co-prime numbers as p and q.
// STEP-2: Compute n as the product of p and q.
// STEP-3: Compute (p-1)*(q-1) and store it in z.
// STEP-4: Select a random prime number e that is less than that of z.
// STEP-5: Compute the private key, d as e * mod-1(z). STEP-6: The cipher text is computed as messagee * mod n. STEP-7: Decryption is done as cipherdmod n.

import java.math.*;
import java.util.*;

public class Ex2bRSA {
    public static void main(String args[]) {
        int p, q, n, z, d = 0, e, i;

        // The number to be encrypted and decrypted
        int msg = 12;
        double c;
        BigInteger msgback;

        // 1st prime number p
        p = 3;

        // 2nd prime number q
        q = 11;
        n = p * q;
        z = (p - 1) * (q - 1);
        System.out.println("the value of z = " + z);

        for (e = 2; e < z; e++) {

            // e is for public key exponent
            if (gcd(e, z) == 1) {
                break;
            }
        }
        System.out.println("the value of e = " + e);
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);

            // d is for private key exponent
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("the value of d = " + d);
        c = (Math.pow(msg, e)) % n;
        System.out.println("Encrypted message is : " + c);

        // converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf(n);

        // converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        System.out.println("Decrypted message is : "
                + msgback);
    }

    static int gcd(int e, int z) {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
}

// OUTPUT
// the value of z = 20
// the value of e = 3
// the value of d = 7
// Encrypted message is : 12.0
// Decrypted message is : 12