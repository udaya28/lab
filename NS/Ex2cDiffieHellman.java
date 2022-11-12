package NS;

// ALGORITHM:

// STEP-1: Both Alice and Bob shares the same public keys g and p.
// STEP-2: Alice selects a random public key a.
// STEP-3: Alice computes his secret key A as ga mod p.
// STEP-4: Then Alice sends A to Bob.

// STEP-5: Similarly Bob also selects a public key b and computes his secret key as B and sends the same back to Alice.
// STEP-6: Now both of them compute their common secret key as the other one’s secret key power of a mod p.

public class Ex2cDiffieHellman {

    // Power function to return value of a ^ b mod P
    private static long power(long a, long b, long p) {
        if (b == 1)
            return a;
        else
            return (((long) Math.pow(a, b)) % p);
    }

    // Driver code
    public static void main(String[] args) {
        long P, G, x, a, y, b, ka, kb;

        // Both the persons will be agreed upon the
        // public keys G and P

        // A prime number P is taken
        P = 23;
        System.out.println("The value of P:" + P);

        // A primitve root for P, G is taken
        G = 9;
        System.out.println("The value of G:" + G);

        // Alice will choose the private key a
        // a is the chosen private key
        a = 4;
        System.out.println("The private key a for Alice:" + a);

        // Gets the generated key
        x = power(G, a, P);

        // Bob will choose the private key b
        // b is the chosen private key
        b = 3;
        System.out.println("The private key b for Bob:" + b);

        // Gets the generated key
        y = power(G, b, P);

        // Generating the secret key after the exchange
        // of keys
        ka = power(y, a, P); // Secret key for Alice
        kb = power(x, b, P); // Secret key for Bob

        System.out.println("Secret key for the Alice is:" + ka);
        System.out.println("Secret key for the Bob is:" + kb);
    }
}

// OUTPUT:
// The value of P:23
// The value of G:9
// The private key a for Alice:4
// The private key b for Bob:3
// Secret key for the Alice is:9
// Secret key for the Bob is:9
