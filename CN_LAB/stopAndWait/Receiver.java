package final1.stopAndWait;

import java.net.*;
import java.io.*;

public class Receiver {
    public static void main(String args[]) throws Exception {
        Receiver r = new Receiver();
        r.run();
    }

    public void run() throws Exception {
        String temp = "any message", str = "exit";

        ServerSocket ss = new ServerSocket(9999);
        Socket ss_acc = ss.accept();

        PrintStream ps = new PrintStream(ss_acc.getOutputStream());
        BufferedReader bf = new BufferedReader(new InputStreamReader(ss_acc.getInputStream()));

        while (temp.compareTo(str) != 0) {
            Thread.sleep(1000);
            temp = bf.readLine();

            if (temp.compareTo(str) == 0) {
                break;
            }

            System.out.println("Frame " + temp + " was received");
            Thread.sleep(500);
            ps.println("Received");
        }
        System.out.println("ALL FRAMES WERE RECEIVED SUCCESSFULLY");
    }
}
