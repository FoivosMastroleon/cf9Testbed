package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;

public class MoviesApp {

    static Scanner scanner = new Scanner(System.in);
    static boolean[] seats = new boolean[10];


    public static void main(String[] args) {

        int choice = 0;
        final int EXIT = 3;

        do{
            menuPrint();
            choice = getChoice();


            switch (choice) {
                case 1:
                    System.out.println("Booking");
                    book();
                    break;
                case 2:
                    System.out.println("Showing seats");
                    showSeats();
                    break;
                case 3:
                    System.out.println("Exit....");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (choice != EXIT);

        System.out.println("Thank you for using our application");


    }

    public static void menuPrint() {
        System.out.println("\n====Start Menu====");
        System.out.println("Choose one of the 3 options:");
        System.out.println("1. Book");
        System.out.println("2. Show seats");
        System.out.println("3. Exit");
        System.out.println("Enter your choice: ");

    }

    public static int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a number (1-3): ");
            scanner.next();

        }
        int num = scanner.nextInt();
        return num;
    }

    public static void book() {



        int seat;

        while (true) {
            System.out.println("Please enter the seat number 1 - 10.");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number (1-10): ");
                scanner.next();
            }
            seat = scanner.nextInt();


            if (seat < 1 || seat > 10) {
                System.out.println("Invalid seat number. Try again");
                continue;

            }


            if (seats[seat - 1]) {
                System.out.println("Sorry. Seat:" + seat + " is already booked");
                continue;

            }


            seats[seat - 1] = true;
            System.out.println("Seat " + seat + " has been booked successfully!");
            System.out.println("Returning to main menu....");
            break;
        }
    }


    public static void showSeats(){

        System.out.println("\n====Seat Availability====");

        for (int i = 0; i < 10; i++){
            int seatNumber = i +1;

            if (seats[i] ){
                System.out.println("Seat " + seatNumber + ": Not Available");
            } else {
                System.out.println("Seat" + seatNumber + ": Available");
            }

    }
        System.out.println("===========");

        scanner.nextLine();

        System.out.println("Do you want to book a seat now? (Y/N) ");
        String answer = scanner.nextLine().trim().toUpperCase();

        if (answer.equals("Y") || answer.equals("YES")){
            book();
        } else {
            System.out.println("Returning to main menu....");
        }




     }
    }





















