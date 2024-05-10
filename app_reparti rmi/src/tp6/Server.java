package tp6;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// Classe principale du serveur rmi
public class Server {
     public static void main(String[] args) {
        try {
            // Crée une instance qui implément  l'interface Calcul  
            CalculImpl obj = new CalculImpl();

            // Convertit l'objet local en un stub  
            Calcul stub = (Calcul) obj;

            //     récupère le registre RMI sur le port 1008
            Registry registry = LocateRegistry.createRegistry(1008);

            // Lie l'objet distant  
            registry.rebind("Calcul", stub);
 
            //   indiquant     le serveur est prêt
            System.err.println("Server ready");
        } catch (Exception e) {
            //   cas d'erreur     affiche un message  
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
