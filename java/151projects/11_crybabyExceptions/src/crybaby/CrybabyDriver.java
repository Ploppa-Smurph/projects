package crybaby;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CrybabyDriver {
    public static void main(String[] args) {
        Crybaby crybaby = new Crybaby();

        try {
            // Attempt to feed approved and NON-approved items
            crybaby.feed("apple"); crybaby.feed("pizza"); crybaby.feed("broccoli");
        } catch (NastyFoodException nf) {
            logError(nf.getMessage());
        }

        try {
            // Attempt to feed and play with NON-approved item
            crybaby.play("tag");
            crybaby.play("imagination time");
            crybaby.play("going to the doctor");
        } catch (DumbGameException dg) {
            logError(dg.getMessage());
        }
    }

    // Helper method to log errors to a file
    public static void logError(String message) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("errors.log", true))) {
        writer.write(message); writer.newLine();
    } catch (IOException ioException) { ioException.printStackTrace();
    }
}
}