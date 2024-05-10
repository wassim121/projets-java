package ex2;

import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Server {
    private static final int PORT = 12345;
    private static HashMap<String, Person> users = new HashMap<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Serveur en cours d'exécution sur le port " + PORT);

            while (true) {
            	  Socket socket = serverSocket.accept();
                  System.out.println("Nouvelle connexion entrante.");

                  // Créez un thread pour gérer la connexion client.
                  ClientHandler clientHandler = new ClientHandler(socket);
                  clientHandler.start();
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registerPerson(Person person) {
        users.put(person.getUsername(), person);
    }

    public static boolean loginPerson(Person person) {
        String username = person.getUsername();
        String password = person.getPassword();

        if (users.containsKey(username)) {
            return users.get(username).getPassword().equals(password);
        }

        return false;
    } public static int retirer(Person person,int s) {
        String username = person.getUsername();
 
        if (users.containsKey(username)) {
            return users.get(username).setSolde(users.get(username).getSolde()-s) ;
        }

        return 0;
    }
}
