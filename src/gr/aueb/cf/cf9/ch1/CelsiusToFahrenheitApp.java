package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;

public class CelsiusToFahrenheitApp {

    public static void main(String[] args) {
        double fahrenheit;

        fahrenheit = celsiusToFahrenheit();


        System.out.println("The temperature in fahrenheit is "+ fahrenheit);






    }

    public static double celsiusToFahrenheit(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please tell us the temperature in Celsius degree");
        double temperature = scanner.nextDouble();
        double fahrenheit = (temperature * (9.0 / 5.0) + 32);

        return fahrenheit;

    }
}
