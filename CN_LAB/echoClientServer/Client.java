package final1.echoClientServer;

import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args)  throws Exception{
        Scanner scan = new Scanner(System.in);
            Socket socket = new Socket("localhost", 9999);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream ps = new PrintStream(socket.getOutputStream());

            while (true) {
                System.out.print("Enter the data ");
                String messageSent = scan.nextLine();
                ps.println(messageSent);

                System.out.println("Server : " + bufferedReader.readLine());
                if (messageSent.equalsIgnoreCase("BYE"))
                    break;
            }
        scan.close();
    }
}
