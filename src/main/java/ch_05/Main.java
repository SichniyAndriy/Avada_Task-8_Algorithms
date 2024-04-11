package ch_05;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoDec codec = new CoDec();
        User user = new User();
        user.savePublicKey(codec.generateKeys());

        System.out.print("Текст: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<String> encrypted = user.encrypt(line);
        System.out.println("Зашифрований текст виглядає так:");
        for (var el: encrypted) {
            System.out.println(el);
        }
        String decrypted = codec.decrypt(encrypted);
        System.out.println("Розшифрований текст виглядає так:");
        System.out.println(decrypted);
    }
}
