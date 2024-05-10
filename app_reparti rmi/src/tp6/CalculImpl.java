package tp6;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// La classe CalculImpl implémente l'interface Calcul et étend UnicastRemoteObject
public class CalculImpl extends UnicastRemoteObject implements Calcul {
    // Constructeur de la classe  
    public CalculImpl() throws RemoteException {
        super();
    }

    // implémentation de la méthode addition  
    @Override
    public int addition(int a, int b) throws RemoteException {
         return a + b;
    }

    // omplémentation de la méthode multiplication  
    @Override
    public int multiplication(int a, int b) throws RemoteException {
        // Retourne le produit des deux nombres
        return a * b;
    }

    // omplémentation de la méthode soustraction 
    @Override
    public int soustraction(int a, int b) throws RemoteException {
        // Retourne la différence entre les deux nombres
        return a - b;
    }

    // implémentation de la méthode division  
    @Override
    public int division(int a, int b) throws RemoteException {
         if (b != 0) {
             return a / b;
        } else {
            //    exception RemoteException si la division par zéro est détectée
            throw new RemoteException("Division by zero is not allowed.");
        }
    }
}
