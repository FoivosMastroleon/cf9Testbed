package gr.aueb.cf.cf9.userapp.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility κλάση για logging σε αρχείο και console.
 *
 * Χρησιμοποιείται για:
 * - Καταγραφή γεγονότων (INFO)
 * - Καταγραφή προειδοποιήσεων (WARNING)
 * - Καταγραφή σφαλμάτων (ERROR)
 */
public class Logger {
    private static final String LOG_FILE = "app.log";
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Καταγραφή γενικού μηνύματος (INFO)
     */
    public static void info(String message) {
        log("INFO", message);
    }

    /**
     * Καταγραφή προειδοποίησης (WARNING)
     */
    public static void warning(String message) {
        log("WARNING", message);
    }

    /**
     * Καταγραφή σφάλματος (ERROR)
     */
    public static void error(String message) {
        log("ERROR", message);
    }

    /**
     * Καταγραφή exception με stack trace
     */
    public static void error(String message, Exception e) {
        log("ERROR", message + " - " + e.getMessage());
        e.printStackTrace();
    }

    /**
     * Κύρια μέθοδος logging
     */
    private static void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logMessage = String.format("[%s] [%s] %s", timestamp, level, message);

        // Εκτύπωση στο console
        System.out.println(logMessage);

        // Αποθήκευση σε αρχείο
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(logMessage);
        } catch (IOException e) {
            System.err.println("Σφάλμα κατά την εγγραφή στο log: " + e.getMessage());
        }
    }
}