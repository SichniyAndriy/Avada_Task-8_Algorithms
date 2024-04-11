package ch_05;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

public class CoDec {
    private BigInteger[] keyPriv;

    public BigInteger[] generateKeys() {
        Random random = new Random();
        BigInteger p = BigInteger.probablePrime(1024, random);
        BigInteger q = BigInteger.probablePrime(1024, random);
        BigInteger n = p.multiply(q);
        BigInteger eyler = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        BigInteger e = BigInteger.probablePrime(256, random);
        BigInteger d = e.modInverse(eyler);
        keyPriv = new BigInteger[] { d, n };

        return new BigInteger[] { e, n };
    }

    public String decrypt(List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (var el: stringList) {
            BigInteger value = new BigInteger(el);
            BigInteger modded = value.modPow(keyPriv[0], keyPriv[1]);
            stringBuilder.append((char) modded.intValue());
        }
        return stringBuilder.toString();
    }
}
