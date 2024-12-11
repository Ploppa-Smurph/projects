package basicPortfolio.ecomapp.shipping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShippingApp {

    public static void runShipping(boolean isInternational, Scanner scanner) {
        System.out.println("\n");
        System.out.println("***********************************");
        System.out.println("*    PULP PLANET ONLINE ORDERS    *");
        System.out.println("*SHIPPING FACILITY INCOMING ORDERS*");
        System.out.println("***********************************");
        System.out.println("\n");

        ShipProcessing shipProcessing = new ShipProcessing();
        List<Shipping> usOrders = new ArrayList<>();
        List<Shipping> internationalOrders = new ArrayList<>();
        double totalOrderValue = 0.0;

        try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) {
            String line;
            int orderId = 0; // Order ID starts from 0
            List<String[]> orderDetailsList = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                // Check for line format to parse order details
                if (line.startsWith("Order Number:")) {
                    // When encountering a new order, process the previous one (if exists)
                    if (!orderDetailsList.isEmpty()) {
                        String[][] orderDetails = orderDetailsList.toArray(new String[0][]);
                        Shipping shippingOrder;
                        if (isInternational) {
                            shippingOrder = new InternationalShipping(orderId, LocalDate.now(), orderDetails, 50.0); // Example shipping cost
                            internationalOrders.add(shippingOrder);
                        } else {
                            shippingOrder = new Shipping(orderId, LocalDate.now(), orderDetails);
                            usOrders.add(shippingOrder);
                        }
                        totalOrderValue += shippingOrder.calculateTotalAmount();
                        orderDetailsList.clear();
                    }
                    // Update order ID
                    orderId = Integer.parseInt(line.split(":")[1].trim());
                } else if (line.contains(" x ") && line.contains(" at $")) {
                    String[] parts = line.split(" x | at \\$| each");
                    if (parts.length == 3) {
                        int quantity = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        double price = Double.parseDouble(parts[2].trim());
                        orderDetailsList.add(new String[]{name, String.valueOf(quantity), String.valueOf(price)});
                    } else {
                        System.err.println("Invalid order format: " + line);
                    }
                }
            }

            // Process the last collected order details
            if (!orderDetailsList.isEmpty()) {
                String[][] orderDetails = orderDetailsList.toArray(new String[0][]);
                Shipping shippingOrder;
                if (isInternational) {
                    shippingOrder = new InternationalShipping(orderId, LocalDate.now(), orderDetails, 50.0); // Example shipping cost
                    internationalOrders.add(shippingOrder);
                } else {
                    shippingOrder = new Shipping(orderId, LocalDate.now(), orderDetails);
                    usOrders.add(shippingOrder);
                }
                totalOrderValue += shippingOrder.calculateTotalAmount();
            }

        } catch (IOException e) {
            System.err.println("Error reading order file: " + e.getMessage());
        }

        try {
            for (Shipping order : usOrders) {
                if (order.calculateTotalAmount() > 10000) { // Example condition to throw the exception
                    throw new ShipProcessingException("Order total exceeds limit: " + order.calculateTotalAmount());
                }
                shipProcessing.addOrder(order);
            }
            for (Shipping order : internationalOrders) {
                if (order.calculateTotalAmount() > 10000) { // Example condition to throw the exception
                    throw new ShipProcessingException("Order total exceeds limit: " + order.calculateTotalAmount());
                }
                shipProcessing.addOrder(order);
            }

            // Save and load orders to and from a file without displaying the details
            shipProcessing.saveOrdersToFile("shipping_orders.txt");
            shipProcessing.loadOrdersFromFile("shipping_orders.txt");

            // Display orders broken into US and international categories
            System.out.println(" *********************");
            System.out.println("   * US SHIPPING *");
            System.out.println(" *********************");
            System.out.println("\n");
            for (Shipping order : usOrders) {
                System.out.println(order);
            }

            System.out.println("\n");
            System.out.println(" ************************");
            System.out.println("* INTERNATIONAL SHIPPING *");
            System.out.println(" ************************");
            ;
            for (Shipping order : internationalOrders) {
                System.out.println(order);
            }

            // Display total order value
            System.out.println("\n");
            System.out.println("**********************");
            System.out.printf(" * Total Order Amount *  =   $%.2f%n", totalOrderValue);
            System.out.println("**********************");

            // Prompt user for date range
            System.out.println("\nEnter start date (YYYY-MM-DD):");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());
            System.out.println("Enter end date (YYYY-MM-DD):");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());

            // Calculate and display total value of shipments within date range
            double totalValueInRange = shipProcessing.calculateTotalValueWithinDateRange(startDate, endDate);
            System.out.printf("Total value of shipments from %s to %s: $%.2f%n", startDate, endDate, totalValueInRange);

        } catch (ShipProcessingException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        runShipping(false, new Scanner(System.in)); // Default to non-international for the main method
    }
}