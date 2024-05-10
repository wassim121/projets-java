package ex4;

 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ClientFrame extends JFrame {
    private JTextField textField;
    private JTextArea clientTextArea;

    public ClientFrame() {
        setTitle("UDP Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(20);
        JButton sendButton = new JButton("Send");
        clientTextArea = new JTextArea();
        clientTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(clientTextArea);

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage(textField.getText());
                textField.setText("");
            }
        });

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(sendButton);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void sendMessage(String message) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");  
            int serverPort = 9876;  

            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            clientTextArea.append("Received: " + receivedMessage + "\n");

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClientFrame clientFrame = new ClientFrame();
            clientFrame.setVisible(true);
        });
    }
}
