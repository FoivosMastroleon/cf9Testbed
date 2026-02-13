package gr.aueb.cf.cf9.ch1;

/** Διαχειρίζεται κρατήσεις σε εστιατόριο. Το εστιατόριο έχει 10 τραπέζια.
 * Χρησιμοποιεί while για επανάληψη του αρχικού μενού.
 * Χρησιμοποιεί if για έλεγχο διαθεσιμότητας
 * και μεθόδους όπως η bookTable(), cancelBooking(), showAvailableTables().
 */

import java.util.Scanner;



public class RestaurantApp {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        int tables = 0;

        printMenu();
        bookTable(tables);

    }

    public static void printMenu() {
        System.out.println("=====Restaurant App======");
        System.out.println("Main menu: Coose one of the following options");
        System.out.println("1. Book a table");
        System.out.println("2. Cancel reservation");
        System.out.println("3. Show availability");
        System.out.println("4. Exit");



        Scanner scanner = new Scanner(System.in);

        int startOption = scanner.nextInt();

        while (startOption ==4) {
            System.out.println("Thank you. You are now exiting....");

        }

    }

    public static void menuOption(){

        System.out.println("Choose on of the options 1-4");
        Scanner scanner = new Scanner(System.in);

        int menuOption = scanner.nextInt();

        while (menuOption <1 || menuOption > 4){
            System.out.println("Please choose one valid option");



        }  {


        }


    }




    public static void bookTable(int table) {
        System.out.println("Choose a table between 1 and 10");
        Scanner scanner = new Scanner(System.in);

        int tableNumber = scanner.nextInt();

        if (tableNumber < 1 || tableNumber > 10) {
            System.out.println("Invalid option. Please choose between 1 and 10");
        } else {
            System.out.println("You have successfully made your reservation on table number:" + tableNumber);
        }
        return;

    }
}




