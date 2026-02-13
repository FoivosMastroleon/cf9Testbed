package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;

public class TripCostCalculator {

    public static void main(String[] args) {
        double totalCost ;

        totalCost = calculateTripCost();

        System.out.printf("\n Total trip cost: %.2f$\n", totalCost);

    }

    public static double calculateTripCost(){


        Scanner scanner = new Scanner(System.in);

        System.out.println(" Please tell us the distance");
        int distanceInKilometers = scanner.nextInt();

        System.out.println(" Please tell us the consumption ");
        int liters = scanner.nextInt();

        System.out.println(" Please tell us the gass price" );
        double fuelPrice = scanner.nextDouble();

        double litersNeeded = (distanceInKilometers * liters)/100;
        double totalCost = (litersNeeded * fuelPrice);

        return totalCost;


    }
}
