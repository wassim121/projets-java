package ex2;

import java.io.*;
import java.net.*;
 

public class Client {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // Pour s'inscrire
            out.writeObject("REGISTER");
            System.out.println("REGISTER avec succès.");
            Person registerPerson = new Person("username", "password",30);
            out.writeObject(registerPerson);
            out.flush();

            // Pour se connecter
            out.writeObject("LOGIN");
            Person loginPerson = new Person("username", "password",30);
            out.writeObject(loginPerson);
            out.flush();

            boolean loggedIn = in.readBoolean();
            if (loggedIn) {
                System.out.println("Connecté avec succès.");
                //ajouter retirer solde ici*************************
               
                out.writeObject("RETRER");
                Person  Person = new Person("username", "password",30);
                out.writeObject(Person);
                out.writeObject(2);
                System.out.println("RETRER avec succès votre solde."+Person.getSolde());
                out.flush();

            } else {
                System.out.println("Échec de la connexion.");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
