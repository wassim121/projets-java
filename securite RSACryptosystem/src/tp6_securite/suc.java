package tp6_securite;

import java.math.BigInteger;
import java.security.SecureRandom;

public class suc {
	public static void main(String[] args) {

        int SIZE = 512;
        SecureRandom random = new SecureRandom();
        BigInteger p = new BigInteger(SIZE, 10, random);
        BigInteger q = new BigInteger(SIZE, 10, random);


        while (!p.isProbablePrime(1)) {
            p = new BigInteger(SIZE, 10, random);
        }

        while (!q.isProbablePrime(1) || q.equals(p)) {
            q = new BigInteger(SIZE, 10, random);
        }


        BigInteger N = p.multiply(q);


        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        
        
        
        
        BigInteger PhiN = p.subtract(BigInteger.valueOf(1));
        BigInteger PhiN2 = PhiN.multiply(q.subtract(BigInteger.valueOf(SIZE)));

	}

}
