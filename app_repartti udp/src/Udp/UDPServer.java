package Udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    private static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }

    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876);  

            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String clientData = new String(receivePacket.getData(), 0, receivePacket.getLength());

                 String[] numbers = clientData.split(",");

                int number1 = Integer.parseInt(numbers[0]);
                int number2 = Integer.parseInt(numbers[1]);

                int gcd = calculateGCD(number1, number2);
                String response = "GCD of " + number1 + " and " + number2 + " is: " + gcd;

                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                        receivePacket.getAddress(), receivePacket.getPort());

                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
