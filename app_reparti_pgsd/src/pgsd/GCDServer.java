package pgsd;

import java.net.*;
import java.io.*;

public class GCDServer {
    public static void main(String[] args) {
        try {
            // Crée un socket Datagram écoutant le port 9876
            DatagramSocket serverSocket = new DatagramSocket(9876);

            while (true) {
                // Prépare un paquet pour recevoir les données du client
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                
                // Attends de recevoir un paquet du client
                serverSocket.receive(receivePacket);

                // Convertit les données reçues en une chaîne
                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                
                // Divise la chaîne reçue en deux nombres en utilisant la virgule comme séparateur
                String[] numbers = clientMessage.split(",");
                int num1 = Integer.parseInt(numbers[0]);
                int num2 = Integer.parseInt(numbers[1]);

                // Calcule le PGCD des deux nombres
                int gcd = calculateGCD(num1, num2);
                
                // Prépare la réponse à envoyer au client
                String response = "Le PGCD de " + num1 + " et " + num2 + " est : " + gcd;

                // Récupère l'adresse et le port du client depuis le paquet reçu
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                
                // Convertit la réponse en tableau d'octets et crée un paquet à envoyer au client
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                
                // Envoie la réponse au client
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour calculer le PGCD de deux nombres en utilisant l'algorithme d'Euclide
    private static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }
}
