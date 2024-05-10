package pgsd;

import java.net.*;
import java.io.*;

public class GCDClient {
    public static void main(String[] args) {
        try {
            // Crée un socket Datagram pour la communication
            DatagramSocket clientSocket = new DatagramSocket();
            
            // Adresse du serveur, dans ce cas "localhost"
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Deux nombres à envoyer au serveur pour calculer le PGCD
            int num1 = 48;
            int num2 = 18;
            
            // Crée un message en concaténant les deux nombres avec une virgule
            String message = num1 + "," + num2;
            
            // Convertit le message en tableau d'octets
            byte[] sendData = message.getBytes();
            
            // Crée un paquet à envoyer au serveur avec les données
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
            
            // Envoie le paquet au serveur
            clientSocket.send(sendPacket);

            // Prépare un paquet pour recevoir la réponse du serveur
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
            // Attend la réponse du serveur
            clientSocket.receive(receivePacket);

            // Convertit les données de la réponse en une chaîne
            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            
            // Affiche la réponse du serveur dans la console
            System.out.println("Réponse du serveur : " + serverResponse);

            // Ferme le socket client
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
