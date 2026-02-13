package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;

/** This application is a menu. The user needs to choose one of the 5 valid options
 * In case the user selects a number which is not listed in the menu,
 * gets an error message and need to choose again.
 * For each option the user gets a message and
 * the menu appears again until the user gives
 * number 5 which means exit. An additional feature is added.
 * When the user selects "1. Register", the software redirects him/her
 * in order to create a security code. The code must have 3 digits. If the users
 * select a number with more or less digits they get an error message and they need to try again.
 */

public class Menu2App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int code;


        while (true) {
            System.out.println("MENU");
            System.out.println("1. Register");
            System.out.println("2. About us");
            System.out.println("3. Communication");
            System.out.println("4. Our projects");
            System.out.println("5. Exit");
            choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("You are now exiting");
                break;
            }
            if (choice < 1 || choice > 5) {
                System.out.println("Your choice is not valid. Please choose again");
                continue;
            }
            if (choice == 1) {
                System.out.println("You selected to Register");


                do {
                    System.out.println("Please create your security code with 3 digits");
                    code = scanner.nextInt();

                    if (code == 666) {
                        System.out.println("666 the number of the Beast ");
                        break;
                    } else if (code < 100 || code > 999) {
                        System.out.println("The code you chose is not valid");
                    } else {
                        System.out.println("Thank you for your securing your privacy");
                        System.out.println("Back to home menu");
                    }
                } while (code < 100 || code > 999 || code == 666);
            } else if (choice == 2) {
                System.out.println("Our team pioneers in the development of game-based solutions for inclusion\nand education while we try to empower marginalized\nand vulnerable groups.");
            } else if (choice == 3) {
                System.out.println("Communication info: pitsapidoulas@gmail.com\nTelephone number: 696666666\nAddress: Kotopoulou 3");
            } else if (choice == 4) {
                System.out.println("1. Killing in the name of\n2. Bleed\n3. Cyka Blyat\n4. Spyrus is a tyrant");
            }

        }
    }
}


