package final1;

import java.util.*;

public class SelectiveRepeat {
    int TotalPackets, windowSize, packetsNumber, intPCount;

    public SelectiveRepeat() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the window size");
        windowSize = scn.nextInt();
        System.out.println("enter Total no. of packets");
        TotalPackets = scn.nextInt();
        System.out.println("Do you want to kill any Packets:(y/n)");
        scn.nextLine();
        String strAns = scn.nextLine();
        if (strAns.equals("y")) {
            System.out.println("Enter NO.of Packets to kill");
            packetsNumber = scn.nextInt();
            intPCount = 1;
        }
    }

    public void sRepeat(int pn) throws Exception {
        System.out.println("------------------------------");
        System.out.println("Selective Repeats of packets" + pn);
        System.out.println("-------------------------------");
        Thread.sleep(1000);
        System.out.println("Packet " + (pn) + ("send==>"));
        Thread.sleep(1000);
        System.out.println("Packet" + (pn) + ("received==>"));
        Thread.sleep(2000);
        System.out.println("ACK" + (pn) + " Received");
    }

    public int calculate(int cos, int pno) {
        int n;
        if (cos > pno)
            n = windowSize - (packetsNumber % windowSize);
        else
            n = windowSize - packetsNumber;
        return n;
    }

    public void trans() throws Exception {
        int intC, intCount = 0;
        while (intPCount < TotalPackets) {
            if (intCount == windowSize) {
                System.out.println("Next Session");
                intCount = 0;
            }
            if (packetsNumber == intPCount) {
                System.out.println("Packet" + packetsNumber + "discard---->");
                Thread.sleep(2000);
                intPCount++;
                intC = calculate(windowSize, packetsNumber);
                System.out.println("Remaining Packet to be sent in the fashion" + intC);
                for (int j = 0; j <= intC; j++) {
                    Thread.sleep(1000);
                    System.out.println("Packet " + intPCount + "Sent==>");
                    Thread.sleep(1000);
                    System.out.println("\t\tPacket" + intPCount + " Received");
                    Thread.sleep(2000);
                    System.out.println("ACK" + intPCount + "Received");
                    intPCount++;
                    intCount = 0;
                }
                sRepeat(packetsNumber);
                Thread.sleep(2000);
                System.out.println("next Session");
                intCount = 0;
            } else {
                Thread.sleep(1000);
                System.out.println("Packet" + intPCount + "send==>");
                Thread.sleep(1000);
                System.out.println("\t\t packet" + intPCount + "Received");
                intPCount++;
            }
            intPCount++;
        }
    }

    public static void main(String agr[]) throws Exception {
        SelectiveRepeat obSRA = new SelectiveRepeat();
        obSRA.trans();
    }
}