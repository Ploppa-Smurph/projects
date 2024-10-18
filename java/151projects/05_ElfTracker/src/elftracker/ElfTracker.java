package elftracker;

/*
*** Jeffrey Walley | CTEC151 Project05 - ElfTracker | 09/21/2024
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElfTracker {
    // Main method where execution begins
    public static void main(String[] args) {

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Initialize an ArrayList named elfList using the attributes of the Elf object class
        List<Elf> elfList = new ArrayList<>();

        // While statement that loops the menu until false (user enters 0 to exit)
        while (true) {
            System.out.println("\nWelcome to Elf Tracker.");
            System.out.print("Enter 1 to view elf list, 2 to add an elf, 0 to exit: ");

            // Store user input as choice
            int choice = scanner.nextInt();

            // Exit the program
            if (choice == 0) {
                System.out.println("Thank you for using the elf tracker.");
                break;
            }

            // Print all elves in the list (choice 1)
            else if (choice == 1) {
                for (Elf elf : elfList) {
                    System.out.println(elf);
                }
            }

            // User input to add new elf to 'elfList'
            else if (choice == 2) {
                scanner.nextLine();
                System.out.print("Please enter elf name: ");
                String name = scanner.nextLine();
                System.out.print("Please enter elf height in inches (ints only): ");
                int height = scanner.nextInt();
                elfList.add(new Elf(name, height));
            }

            // Very minimal error message
            else {
                System.out.println("Invalid choice.");
            }
        }
    }
}