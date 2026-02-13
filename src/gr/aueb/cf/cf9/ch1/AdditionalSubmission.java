package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;

public class AdditionalSubmission {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ownsACar = false;
        boolean mustDeclare = false;
        int creationDate = 0;
        int carSeats = 0;

        System.out.println("Please tell us if you own a car (true/false)");
        ownsACar = scanner.nextBoolean();

        if (ownsACar) {
            System.out.println("Please enter the creation date of your car:");
            creationDate = scanner.nextInt();

            System.out.println("Please indicate the number of seats:");
            carSeats = scanner.nextInt();
        }

        mustDeclare = ownsACar && (creationDate >2010) || (carSeats >= 2);

        if (mustDeclare) {
            System.out.println("You must declare your car.");
        } else {
            System.out.println("You don’t have to declare your car.");


        }
    }
}
