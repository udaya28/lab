package final1;
import java.util.Scanner;
public class CRC2 {
    public static void main(String args[]) {
        int d[], n, g[], m, z[], i, j, r[], msb, k;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of data bits ");
        n = sc.nextInt();
        System.out.print("Enter number of generator bits ");
        m = sc.nextInt();

        d = new int[n + m];
        g = new int[m];
        z = new int[m];
        r = new int[n + m];

        System.out.println("Enter data bits ");
        for (i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        System.out.println("Enter generator bits ");
        for (i = 0; i < m; i++) {
            g[i] = sc.nextInt();
        }

        // (m - 1) '0's are added to data bit
        for (i = 0; i < m; i++) {
            d[i + n] = 0;
        }

        // m length of zero's
        for (i = m; i < m; i++) {
            z[i] = 0;
        }

        // copy data to result
        for (i = 0; i < n; i++) {
            r[i] = d[i];
        }

        for (i = 0; i < n; i++) {
            msb = r[i];
            k = 0;

            for (j = i; j < m + i; j++) {
                if (msb == 0) {
                    r[j] = xor(r[j], z[k]);
                } else {
                    r[j] = xor(r[j], g[k]);
                }
                k++;
            }
        }

        System.out.print("the code bit added are:");
        for (i = n; i < n + m - 1; i++) {
            d[i] = r[i];
            System.out.print(d[i]);
        }
        System.out.println("");
        System.out.print("the code data is:");
        for (i = 0; i < n + m - 1; i++) {
            System.out.print(d[i]);
        }
        System.out.println("");
        sc.close();

    }

    private static int xor(int a, int b) {
        if (a == b)
            return 0;
        return 1;
    }
}
