package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;

public class KiloToGrams {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int weightInKilograms = 0;
        int weightInGrams = 0;

        final int KILOGRAMS_TO_GRAMS = 1000;

        System.out.println("Please give us your weight in kilos");

        weightInKilograms = keyboard.nextInt();
        weightInGrams = weightInKilograms * KILOGRAMS_TO_GRAMS;

        System.out.printf("The wight of the %d kilograms is %d in grams\n", weightInKilograms , weightInGrams);

    }
}
