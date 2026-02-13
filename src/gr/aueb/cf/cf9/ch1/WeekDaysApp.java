package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;

/** δέχεται έναν ακέραιο (1-7)
 * και επιστρέφει το αντίστοιχο όνομα της ημέρας της εβδομάδας
 * (π.χ., 1 → "Δευτέρα").
 */


public class WeekDaysApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int userInput = 0;
        char daysOfWeek = ' ';


            System.out.println("Please give a number between 1-7 to indicate the day of the week");
            userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    System.out.println("Sunday");
                    break;
                case 2:
                    System.out.println("Monday");
                    break;
                case 3:
                    System.out.println("Tuesday");
                    break;
                case 4:
                    System.out.println("Wednesday");
                    break;
                case 5:
                    System.out.println("Thursday");
                    break;
                case 6:
                    System.out.println("Friday");
                    break;
                case 7:
                    System.out.println("Saturday");
                    break;
                default:
                    System.out.println("Please give a number between 1-7");
                    break;


            }

    }

}