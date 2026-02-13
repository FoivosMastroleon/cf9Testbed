package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;

public class CaesarCipherApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the message you want to encrypt");
        String message = scanner.nextLine();

        System.out.println("Enter shift value");
        int shift = scanner.nextInt();

        String encrypted = caesarEncrypt(message,shift);
        System.out.println("Encrypted message: " + encrypted);
    }

    public static String caesarEncrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();

        shift = shift % 26;

        for (int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);

            if (Character.isUpperCase(ch)){
                char c = (char) ('A' + (ch - 'A'+ shift) % 26);
                encrypted.append(c);
            } else if (Character.isLowerCase(ch)) {

                char c = (char) ('a' + (ch - 'a' + shift) % 26);
                encrypted.append(c);

            } else {
                encrypted.append(ch);
            }
        }

        return encrypted.toString();
    }


}
