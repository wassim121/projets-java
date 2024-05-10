package corba;

import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

public class Serveur {
    public static void main(String[] args) throws InvalidName, AdapterInactive {
        // Initialize the ORB
    	//a middleware component in CORBA
    	//It acts as an intermediary between clients and servers, facilitating the invocation of methods on remote objects (Remote Object" (objet distant) fait référence à un objet qui réside dans un espace d'adressage différent et qui est accessible via un mécanisme de communication à distance, tel que le CORBA )
        ORB orb = ORB.init(args, null);//pour cree un objet de poa***
        // Get the root POA 
        // a component within CORBA that manages the lifecycle of objects, including their creation, activation, and deactivation.
        org.omg.CORBA.Object objPOA = orb.resolve_initial_references("RootPOA");
        //This is a standard name for obtaining the Root POA.
        POA rootPOA = POAHelper.narrow(objPOA);
        // Activate the POA manager
        rootPOA.the_POAManager().activate();
        // Create an instance of your servant implementation
        CalculImpl calcul = new CalculImpl();
        org.omg.CORBA.Object obj = calcul._this(orb);
        // Print the object reference
        System.out.println(orb.object_to_string(obj));
        // Run the ORB
        orb.run();
    }
}
