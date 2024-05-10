package tp6_securite;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSACryptosystem {

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


        BigInteger e = new BigInteger("65537");  


        while (e.compareTo(phiN) != -1 || e.gcd(phiN).compareTo(BigInteger.ONE) != 0) {
            e = new BigInteger(2 * SIZE, random);
        }


        BigInteger d = e.modInverse(phiN);


        BigInteger message = new BigInteger("123456");


        BigInteger ciphertext = message.modPow(e, N);


        BigInteger decryptedMessage = ciphertext.modPow(d, N);


        System.out.println("Message initial : " + message);
        System.out.println("Message décrypté : " + decryptedMessage);
        System.out.println("Les deux messages sont-ils identiques ? " + message.equals(decryptedMessage));
    }
}