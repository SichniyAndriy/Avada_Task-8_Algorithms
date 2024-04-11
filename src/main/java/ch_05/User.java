package ch_05;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class User {
    @Getter
    private BigInteger[] keyPub;
    private final List<String> buffer = new ArrayList<>();

    public void savePublicKey(BigInteger[] key) {
        keyPub = key;
    }

    public List<String> encrypt(String line) {
        buffer.clear();
        char[] charArray = line.toCharArray();
        for (var el: charArray) {
            BigInteger value = BigInteger.valueOf(el).modPow(keyPub[0], keyPub[1]);
            buffer.add(value.toString());
        }
        return buffer;
    }
}
