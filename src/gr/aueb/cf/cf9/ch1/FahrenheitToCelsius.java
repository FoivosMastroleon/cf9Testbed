package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;



public class FahrenheitToCelsius {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fahrenheit = 0;
        int celsius  = 5 * (fahrenheit-32) / 9;;



        System.out.println("Παρακαλω δώστε τη θερμοκρασία του χώρου σας σε fahrenheit");


        fahrenheit =scanner.nextInt();
        celsius = 5 * (fahrenheit-32) / 9;

        System.out.printf("Η θερμοκρασία του χώρου σας για τους %d βαθμούς Fahrenheit αντιστοιχούν σε %d βαθμούς Celsius", fahrenheit , celsius);
    }
}
