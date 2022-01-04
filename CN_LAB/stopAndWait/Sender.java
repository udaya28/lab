package final1.stopAndWait;

import java.io.*;
import java.net.*;
import java.util.*;

public class Sender {

    public static void main(String args[]) throws Exception{
        Sender s = new Sender();
        s.run();
    }

    public void run() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no of frames to be sent: ");
        int n = sc.nextInt();

        Socket ss = new Socket("localhost", 9999);
        PrintStream ps = new PrintStream(ss.getOutputStream());
        BufferedReader bf = new BufferedReader(new InputStreamReader(ss.getInputStream()));
        
        for (int i = 0; i <= n;) {
            if (i == n) {
                ps.println("exit");
                break;
            }

            System.out.println("Frame no " + i + " is sent");
            ps.println(i);

            String ack = bf.readLine();

            if (ack != null) {
                System.out.println("Acknowledgement was Received from receiver");
                i++;
                Thread.sleep(4000);
            }
        }
        sc.close();
    }
}
