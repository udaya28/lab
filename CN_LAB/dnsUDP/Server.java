package final1.dnsUDP;

import java.io.*;
import java.net.*;

public class Server {
    private static int indexOf(String[] array, String str) {
        str = str.trim();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(str))
                return i;
        }
        return -1;
    }

    public static void main(String arg[]) throws IOException {
        String[] hosts = { "yahoo.com", "gmail.com", "cricinfo.com", "facebook.com" };
        String[] ip = { "68.180.206.184", "209.85.148.19", "80.168.92.140", "69.63.189.16" };
        System.out.println("Press Ctrl + C to Quit");
        while (true) {
            DatagramSocket serverSocket = new DatagramSocket(1362);
            byte[] sendData = new byte[1021];
            byte[] receiveData = new byte[1021];

            DatagramPacket receivedPack = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivedPack);

            String sen = new String(receivedPack.getData());
            InetAddress ipAddress = receivedPack.getAddress();
            int port = receivedPack.getPort();

            String hostIp;
            System.out.println("Request for host " + sen);
            if (indexOf(hosts, sen) != -1)
                hostIp = ip[indexOf(hosts, sen)];
            else
                hostIp = "Host Not Found";

            sendData = hostIp.getBytes();
            DatagramPacket pack = new DatagramPacket(sendData, sendData.length, ipAddress, port);
            serverSocket.send(pack);

            serverSocket.close();
        }
    }
}
