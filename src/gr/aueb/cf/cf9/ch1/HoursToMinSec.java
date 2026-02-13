package gr.aueb.cf.cf9.ch1;


import java.util.Scanner;


public class HoursToMinSec {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Tell us your temperature in fahrenheit");

        int fahrenheit = scanner.nextInt();
        int celsius = 5 * (fahrenheit -32) / 9;

        System.out.printf("Your temperature in Celsius is: %d\n", celsius);


    }
}

