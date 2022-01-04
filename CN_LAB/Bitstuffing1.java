package final1;
import java.util.*;

public class Bitstuffing1 {
    public static void main(String args[]) {
        int i = 0, l;
        String sy = "01111110", sx;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the data : ");
        sx = scan.nextLine();
        StringBuilder sby = new StringBuilder(sy);
        StringBuilder sbx = new StringBuilder(sx);
        l = sbx.length();
        while (i + 5 <= l) {
            if (check(sbx.substring(i, i + 5))) {
                sbx.insert(i + 5, 0);
                i += 6;
            } else {
                i++;
            }
        }
        System.out.println("bit stuffed:");
        System.out.println(sbx);
        System.out.println("final output:");
        System.out.println(sby + " " + sbx + " " + sby);
        System.out.println(sby.append(sbx.append(sby)));
        scan.close();
    }

    private static boolean check(String s) {
        String s1 = "11111";
        return s.equals(s1);
    }
}
