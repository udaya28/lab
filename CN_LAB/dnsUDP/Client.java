
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        InetAddress ipAddress;
        int portAddr = 1362;

        if (args.length == 0)
            ipAddress = InetAddress.getLocalHost();
        else
            ipAddress = InetAddress.getByName(args[0]);
            
        System.out.print("Enter the hostname : ");
        String sentence = br.readLine();
        sendData = sentence.getBytes();

        DatagramPacket pack = new DatagramPacket(sendData, sendData.length, ipAddress, portAddr);
        clientSocket.send(pack);

        DatagramPacket recvPack = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(recvPack);

        String modified = new String(recvPack.getData());
        System.out.println("IP Address: " + modified);

        clientSocket.close();
    }
}