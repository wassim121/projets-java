package ex4;
import javax.swing.*;
import java.awt.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerFrame extends JFrame {
    private JTextArea serverTextArea;

    public ServerFrame() {
        setTitle("UDP Server");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        serverTextArea = new JTextArea();
        serverTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(serverTextArea);

        add(scrollPane, BorderLayout.CENTER);

         startServer();
    }

    private void startServer() {
        new Thread(() -> {
            try {
                DatagramSocket socket = new DatagramSocket(9876);  
                serverTextArea.append("Server started...\n");

                byte[] receiveData = new byte[1024];

                while (true) {
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    socket.receive(receivePacket);

                    String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    InetAddress clientAddress = receivePacket.getAddress();
                    int clientPort = receivePacket.getPort();

                     
                    String modifiedMessage = "Received: " + receivedMessage + "\n";
                    modifiedMessage += "Length: " + receivePacket.getLength() + " bytes\n";
                    modifiedMessage += "Date: " + new java.util.Date() + "\n";
                    modifiedMessage += "Client Address: " + clientAddress + "\n";
                    modifiedMessage += "Client Port: " + clientPort + "\n\n";

                    serverTextArea.append(modifiedMessage);

                    byte[] sendData = modifiedMessage.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                    socket.send(sendPacket);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ServerFrame serverFrame = new ServerFrame();
            serverFrame.setVisible(true);
        });
    }
}
