package gr.aueb.cf.cf9.userapp.service;

import gr.aueb.cf.cf9.userapp.model.User;
import gr.aueb.cf.cf9.userapp.util.Logger;

import java.util.Scanner;

/**
 * Service για διαχείριση του κύριου μενού της εφαρμογής.
 *
 * Παρέχει 3 επιλογές + έξοδος
 */
public class MenuService {

    private final Scanner scanner;
    private final User loggedInUser;

    public MenuService(Scanner scanner, User loggedInUser) {
        this.scanner = scanner;
        this.loggedInUser = loggedInUser;
    }

    /**
     * Εμφανίζει το μενού και διαχειρίζεται τις επιλογές
     */
    public void show() {
        int choice = 0;

        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║   Καλωσήρθες, " + loggedInUser.username() + "!");
        System.out.println("╚═══════════════════════════════════════╝");

        while (choice != 4) {
            displayMenu();

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        option1();
                        break;
                    case 2:
                        option2();
                        break;
                    case 3:
                        option3();
                        break;
                    case 4:
                        exit();
                        break;
                    default:
                        System.out.println("❌ Μη έγκυρη επιλογή. Παρακαλώ επιλέξτε 1-4.");
                        Logger.warning("Μη έγκυρη επιλογή μενού: " + choice);
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Παρακαλώ εισάγετε έναν αριθμό (1-4).");
                Logger.warning("Μη έγκυρη είσοδος στο μενού");
            }

            System.out.println();
        }
    }

    /**
     * Εμφάνιση μενού επιλογών
     */
    private void displayMenu() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│         ΚΥΡΙΟ ΜΕΝΟΥ                 │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ 1. Προβολή Προφίλ                   │");
        System.out.println("│ 2. Αλλαγή Email                     │");
        System.out.println("│ 3. Στατιστικά Χρήσης                │");
        System.out.println("│ 4. Έξοδος                           │");
        System.out.println("└─────────────────────────────────────┘");
        System.out.print("Επιλογή: ");
    }

    /**
     * Επιλογή 1: Προβολή Προφίλ
     */
    private void option1() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│       ΤΟ ΠΡΟΦΙΛ ΜΟΥ                 │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.printf("│ Username: %-25s │%n", loggedInUser.username());
        System.out.printf("│ Email:    %-25s │%n", loggedInUser.email());
        System.out.printf("│ Password: %-25s │%n", "***HIDDEN***");
        System.out.println("└─────────────────────────────────────┘");

        Logger.info("Χρήστης " + loggedInUser.username() + " προβολή προφίλ");
    }

    /**
     * Επιλογή 2: Αλλαγή Email
     */
    private void option2() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│       ΑΛΛΑΓΗ EMAIL                  │");
        System.out.println("└─────────────────────────────────────┘");

        System.out.println("Τρέχον email: " + loggedInUser.email());
        System.out.print("Νέο email: ");
        String newEmail = scanner.nextLine();

        if (newEmail.isBlank()) {
            System.out.println("❌ Το email δεν μπορεί να είναι κενό.");
            Logger.warning("Αποτυχία αλλαγής email - κενό email");
            return;
        }

        if (!newEmail.contains("@")) {
            System.out.println("❌ Μη έγκυρο email. Πρέπει να περιέχει @");
            Logger.warning("Αποτυχία αλλαγής email - μη έγκυρο format");
            return;
        }

        System.out.println("✓ Το email άλλαξε επιτυχώς!");
        System.out.println("(Σημείωση: Σε πραγματική εφαρμογή θα γινόταν update στη βάση)");

        Logger.info("Χρήστης " + loggedInUser.username() + " άλλαξε email σε: " + newEmail);
    }

    /**
     * Επιλογή 3: Στατιστικά
     */
    private void option3() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│       ΣΤΑΤΙΣΤΙΚΑ ΧΡΗΣΗΣ             │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ Συνδέσεις σήμερα:        5          │");
        System.out.println("│ Συνολικές συνδέσεις:     142        │");
        System.out.println("│ Τελευταία σύνδεση:       Σήμερα     │");
        System.out.println("│ Μέλος από:               01/01/2025 │");
        System.out.println("└─────────────────────────────────────┘");

        Logger.info("Χρήστης " + loggedInUser.username() + " προβολή στατιστικών");
    }

    /**
     * Έξοδος από την εφαρμογή
     */
    private void exit() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║  Αντίο " + loggedInUser.username() + "! Ελπίζουμε να σε ξαναδούμε!");
        System.out.println("╚═══════════════════════════════════════╝");

        Logger.info("Χρήστης " + loggedInUser.username() + " αποσυνδέθηκε");
    }
}