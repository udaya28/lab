package final1;

import java.util.*;

public class GoBackN {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the Window Size: ");
        int window = sc.nextInt();
        boolean flag = true;
        int sent = 0;
        while (flag) {
            for (int i = 0; i < window; i++) {
                System.out.println("Frame " + sent + " has been transmitted.");
                sent++;
                if (sent == window)
                    break;
            }

            System.out.println("Please enter the last Acknowledgement received.");
            int ack = sc.nextInt();
            if (ack == window)
                flag = false;
            else
                sent = ack;
        }
        sc.close();
    }
}