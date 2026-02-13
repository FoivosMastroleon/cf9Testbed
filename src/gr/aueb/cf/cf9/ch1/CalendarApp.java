package gr.aueb.cf.cf9.ch1;

import java.util.Locale;
import java.util.Scanner;

public class CalendarApp {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int day;
        int month;
        int year;

        System.out.println("Παρακαλώ δώστε μας την σημερινή ημερομηνία σε μορφή ημέρα/ μήνας/ έτος");

        day = keyboard.nextInt();
        month = keyboard.nextInt();
        year = keyboard.nextInt();

        System.out.printf("Η σημερινή ημερομηνία είναι %d / %d / %d \n", day, month, year);
    }
}