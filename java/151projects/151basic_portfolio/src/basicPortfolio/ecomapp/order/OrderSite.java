package basicPortfolio.ecomapp.order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class OrderSite {
    private static int getLastOrderId() {
        int lastOrderId = 0;
        try {
            for (String line : Files.readAllLines(Paths.get("orders.txt"))) {
                if (line.startsWith("Order Number:")) {
                    lastOrderId = Integer.parseInt(line.split(":")[1].trim());
                }
            }
        } catch (IOException e) {
            // Ignore if file doesn't exist yet
        }
        return lastOrderId;
    }

    public static void run(Scanner scanner) {
        Catalog catalog = new Catalog();
        Order order = new Order();
        boolean continueOrder = true;


        try {
            System.out.println("Ch08, Ch09, Ch10, Ch11, Ch12: CH8 - Properly utilize a 2-Dimensional array; Properly Override a method in a subclass; Properly utilize super() in a subclass constructor; Properly implement the Comparable interface on a class; Create a custom exception; Properly implement a try/catch statement; Properly write data to file via code; Display an understanding of how a recursive algorithm of your choice is implemented in detail \n");
            // Ask if the order is from the United States or international
            System.out.println("Is this a United States (US) order or International (INT) order?");
            String orderType = scanner.nextLine();
            if (!orderType.equalsIgnoreCase("US") && !orderType.equalsIgnoreCase("INT")) {
                throw new InvalidOrderTypeException("Invalid order type. Please enter 'US' or 'INT'.");
            }
            boolean isInternational = orderType.equalsIgnoreCase("INT");

            int orderId = getLastOrderId() + 1;

            while (continueOrder) {
                System.out.println("\n=== Catalog ===");
                catalog.listCatalog();
                System.out.println("Enter the item number to order, or 0 to finish:");
                int itemNumber = scanner.nextInt();
                if (itemNumber == 0) break;

                Item item = catalog.getItem(itemNumber);
                if (item == null) {
                    throw new InvalidItemSelectionException("Invalid item number. Please select a valid item from the catalog.");
                }

                System.out.println("Enter quantity:");
                int quantity = scanner.nextInt();
                scanner.nextLine();  // consume newline

                System.out.println("Select type (1 for Basic, 2 for Premium):");
                int type = scanner.nextInt();
                scanner.nextLine();  // consume newline

                double itemCost = (type == 1) ? item.getBasicCost() : item.getPremiumCost();

                System.out.println("Adding to order: " + quantity + " x " + item.getName() + " at $" + itemCost + " each.");
                order.addItem(item.getName(), quantity, itemCost);

                System.out.println("Subtotal: $" + order.getTotalCost());
                System.out.println("Would you like to add another item? (yes/y for yes, any other key for no)");
                String response = scanner.nextLine();

                if (!(response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y"))) {
                    continueOrder = false;
                }
            }

            // Display final order
            System.out.println("\nFinal Order:");
            System.out.println(order);

            // Append order to orders.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt", true))) { // true means append mode
                writer.write("Order Number: " + orderId + "\n");
                writer.write("Date: " + java.time.LocalDate.now() + "\n");
                for (String item : order.getItems()) {
                    writer.write(item + "\n");
                }
                writer.write("Total Cost: $" + order.getTotalCost() + "\n\n");
            } catch (IOException e) {
                System.err.println("Error saving order: " + e.getMessage());
            }

            // Launch the shipping project based on order type
            basicPortfolio.ecomapp.shipping.ShippingApp.runShipping(isInternational, scanner);

        } catch (InvalidOrderTypeException | InvalidItemSelectionException e) {
            System.err.println(e.getMessage());
        }

        // Do not close the scanner here to avoid affecting the BasicPortfolio app
    }
}
