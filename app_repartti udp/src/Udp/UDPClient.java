package Udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            int number1 = 42; // Replace   your first number
            int number2 = 56; // Replace k your second number

            String data = number1 + "," + number2;

            byte[] sendData = data.getBytes();
            InetAddress IPAddress = InetAddress.getByName("localhost");

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            clientSocket.receive(receivePacket);

            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("FROM SERVER: " + response);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
