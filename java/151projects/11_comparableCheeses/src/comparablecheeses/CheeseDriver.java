package comparablecheeses;

import java.util.Scanner;

public class CheeseDriver {
    public static void main(String[] args) {
        CheeseList cheeseList = new CheeseList();

        // Start with an initial cheese list
        cheeseList.addCheese(new Cheese("Stinking Bishop", 6, 9));
        cheeseList.addCheese(new Cheese("Limburger",8, 5));
        cheeseList.addCheese(new Cheese("Burns Farmstead Cheese",3, 7));
        cheeseList.addCheese(new Cheese("Esrom",4, 4));
        cheeseList.addCheese(new Cheese("Taleggio",7, 8));

        Scanner scanner = new Scanner(System.in);
        String userResponse;

        do {
            // Sort the cheeses
            cheeseList.selectionSort();

            // Print out all the cheeses in the sorted order
            cheeseList.printCheeses();

            // Ask User to add new cheese
            System.out.print("Would you like to add a new cheese? (yes/no): ");
            userResponse = scanner.nextLine().trim().toLowerCase();

            if (userResponse.equals("yes")) {

                // Prompt user for cheese details
                System.out.print("Enter cheese name: ");
                String name = scanner.nextLine();
                System.out.print("Enter cheese stinkiness (0-10): ");
                int stinkiness = scanner.nextInt();
                System.out.print("Enter cheese flavor (0-10): ");
                int flavor = scanner.nextInt();
                // Consume the newline character
                scanner.nextLine();

                // Add the new cheese to the list
                cheeseList.addCheese(new Cheese(name, stinkiness, flavor));
            }
        } while (userResponse.equals("yes"));

        // Close the scanner
        scanner.close();

        // Final display of the cheese list
        System.out.println("\nFinal Cheese List:"); cheeseList.selectionSort(); cheeseList.printCheeses();
    }
}