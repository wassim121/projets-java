package corba;

import org.omg.CORBA.ORB;

public class Client {
    public static void main(String[] args) {
        // Initialize the ORB (Object Request Broker)
        ORB orb = org.omg.CORBA.ORB.init(args, null);
        // Convert the string representation of the object reference to a CORBA object
        CalculModule.Calcul server = CalculModule.CalculHelper.narrow(orb.string_to_object("IOR:000000000000001c49444c3a43616c63756c4d6f64756c652f43616c63756c3a312e3000000000010000000000000086000102000000000d3137322e32392e3136302e310000ef3000000031afabcb000000002045f5033600000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002"));

        // Invoke the 'soustraction' and 'multiplication' operations on the remote server object
        System.out.println(server.soustraction(1, 2));
        System.out.println(server.multiplication(1, 2));
    }
}
