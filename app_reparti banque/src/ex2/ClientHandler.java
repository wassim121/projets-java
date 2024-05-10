package ex2;

import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            while (true) {
                // Attendez de recevoir une requête de l'utilisateur.
                Object receivedData = in.readObject();

                if (receivedData instanceof String) {
                    String request = (String) receivedData;
                    //catch retirer et faire loperatio******************
                    if (request.equals("REGISTER")) {
                        // L'utilisateur souhaite s'inscrire.
                        Person person = (Person) in.readObject();
                        Server.registerPerson(person);
                    } else if (request.equals("LOGIN")) {
                        // L'utilisateur tente de se connecter.
                        Person person = (Person) in.readObject();
                        boolean loggedIn = Server.loginPerson(person);
                        out.writeBoolean(loggedIn);
                        out.flush();
                    }else if (request.equals("RETIRER")) {
                        // L'utilisateur tente de se connecter.
                        Person person = (Person) in.readObject();
                        int s = (int) in.readObject();
                        int Solde = Server.retirer(person,s);
                        out.writeByte(Solde);
                        out.flush();
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

