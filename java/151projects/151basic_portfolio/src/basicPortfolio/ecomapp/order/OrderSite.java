package basicPortfolio.ecomapp.order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class OrderSite {

    /**
     * This method is recursive.
     * It traverses the list of lines from a file to find the last order ID.
     * It accomplishes this by calling on itself within the method body.
     * findLastOrderID takes 3 parameters: List<> of lines that contains String data types;
     * an index integer that holds the current index being processed; the lastOrderID -- most recently found order id.
     */
    private static int findLastOrderId(List<String> lines, int index, int lastOrderId) {
        if (index < lines.size()) {
            String line = lines.get(index);
            if (line.startsWith("Order Number:")) {
                lastOrderId = Integer.parseInt(line.split(":")[1].trim());
            }
            return findLastOrderId(lines, index + 1, lastOrderId);
        } else {
            return lastOrderId;
        }
    }

    private static int getLastOrderId() {
        int lastOrderId = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get("orders.txt"));
            lastOrderId = findLastOrderId(lines, 0, lastOrderId);
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
            System.out.println("\n Ch08, Ch09, Ch10, Ch11, Ch12: CH8 - Properly utilize a 2-Dimensional array; Properly Override a method in a subclass; Properly utilize super() in a subclass constructor; Properly implement the Comparable interface on a class; Create a custom exception; Properly implement a try/catch statement; Properly write data to file via code; Display an understanding of how a recursive algorithm of your choice is implemented in detail \n");
            // Ask if the order is from the United States or international
            System.out.println("Is this a United States (US) order or International (INT) order?");
            String orderType = scanner.nextLine();
            if (!orderType.equalsIgnoreCase("US") && !orderType.equalsIgnoreCase("INT")) {
                throw new InvalidOrderTypeException("Invalid order type. Please enter 'US' or 'INT'.");
            }
            boolean isInternational = orderType.equalsIgnoreCase("INT");

            int orderId = getLastOrderId() + 1;

            while (continueOrder) {
                catalog.listCatalogSimple();
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

                System.out.println("Select type (1 for Basic - $" + item.getBasicCost() + ", 2 for Premium - $" + item.getPremiumCost() + "):");
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
            System.out.println("\nInitial Order: ");
            System.out.println(order);

            // Ask for confirmation and inform about the shipping fee if international
            System.out.println("Would you like to proceed with the order? (yes/no)");
            if (isInternational) {
                System.out.println("Please note: International orders face a $50 shipping fee.");
            }
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                // Append order to orders.txt with a line break between each order for readability
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt", true))) { // true means append mode
                    writer.write("Order Number: " + orderId + "\n");
                    writer.write("Date: " + java.time.LocalDate.now() + "\n");
                    for (String item : order.getItems()) {
                        writer.write(item + "\n");
                    }
                    writer.write("Total Cost: $" + order.getTotalCost() + "\n");
                    writer.write("\n");  // Add a blank line for readability
                } catch (IOException e) {
                    System.err.println("Error saving order: " + e.getMessage());
                }

                // Proceed directly to shipping without displaying order details or asking for shipping confirmation
                basicPortfolio.ecomapp.shipping.ShippingApp.runShipping(isInternational, scanner);
            } else {
                System.out.println("Order cancelled.");
            }

        } catch (InvalidOrderTypeException | InvalidItemSelectionException e) {
            System.err.println(e.getMessage());
        }

        // Do not close the scanner here to avoid affecting the BasicPortfolio app
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
    }
}
