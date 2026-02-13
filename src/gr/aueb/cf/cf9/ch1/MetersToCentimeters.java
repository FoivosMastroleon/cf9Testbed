package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;


/**Δέχεται απο τον χρήστη εναν ακέραιο αριθμό
 * που αντιστοιχεί σε μια απόσταση σε μέτρα
 * και τα μετατρέπει σε εκατοστά
 *
 */

public class MetersToCentimeters {


    public static void main(String[] args) {

        int meters;
        int centimeters;
        final int METERS_TO_CENTIMETERS = 100;

        // δέχεται το πληκτρολόγιο ως πηγή εισόδου


        Scanner scanner = new Scanner(System.in);


        System.out.println("Παρακαλώ δώστε την απόσταση σε μέτρα");

         meters = scanner.nextInt();

         centimeters = meters * METERS_TO_CENTIMETERS;

        System.out.printf("Η απόσταση των %d μέτρων, αντιστοιχεί σε %,d εκατοστά" , meters , centimeters );

    }
}
