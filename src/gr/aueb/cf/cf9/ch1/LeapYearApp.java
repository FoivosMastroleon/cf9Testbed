package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;

public class LeapYearApp{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        final int YEAR_IN_DAYS = 365;
        final int LEAP_YEAR_IN_DAYS = 366;
        boolean isLeap;

        while (true) {
            System.out.println("Please write the year (0 to exit:)");
            year = scanner.nextInt();

            if (year == 0) {
                System.out.println("Exiting program");
                break;
            }

            isLeap = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));

            if (isLeap) {
                System.out.println(year + " is a leap year\n");

            } else {
                System.out.println(year + " is not a leap year\n");
            }
        }
    }
}
