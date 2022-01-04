package final1.echoClientServer;

import java.io.*;
import java.net.*;
import java.util.Scanner;
 
public class Server {
    public static void main(String[] args) throws Exception {
 
        System.out.println("Server Started....");
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream ps = new PrintStream(socket.getOutputStream());
 
            Scanner scan = new Scanner(System.in);
 
            while(true){
                String messageReceived = bufferedReader.readLine();
                ps.println("Message Received...");
                System.out.println("Client's message : "+messageReceived);
                if (messageReceived.equalsIgnoreCase("BYE"))
                    break;
            }
            scan.close();
    }    
}
