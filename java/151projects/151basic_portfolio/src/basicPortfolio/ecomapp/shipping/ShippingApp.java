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
        ShipProcessing shipProcessing = new ShipProcessing();
        List<Shipping> shippingOrders = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) {
            String line;
            int orderId = 1; // Example order ID incrementer
            List<String[]> orderDetailsList = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                // Check for line format to parse order details
                if (line.contains(" x ") && line.contains(" at $")) {
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

            // Process the collected order details
            if (!orderDetailsList.isEmpty()) {
                String[][] orderDetails = new String[orderDetailsList.size()][3];
                orderDetails = orderDetailsList.toArray(orderDetails);
                Shipping shippingOrder;
                if (isInternational) {
                    shippingOrder = new InternationalShipping(orderId, LocalDate.now(), orderDetails, 50.0); // Example shipping cost
                } else {
                    shippingOrder = new Shipping(orderId, LocalDate.now(), orderDetails);
                }
                shippingOrders.add(shippingOrder);
            }

        } catch (IOException e) {
            System.err.println("Error reading order file: " + e.getMessage());
        }

        try {
            double totalValue = 0.0;
            for (Shipping order : shippingOrders) {
                if (order.calculateTotalAmount() > 10000) { // Example condition to throw the exception
                    throw new ShipProcessingException("Order total exceeds limit: " + order.calculateTotalAmount());
                }
                shipProcessing.addOrder(order);
                totalValue += order.calculateTotalAmount();
            }

            // Display final shipping details and total value
            shipProcessing.printOrders();
            System.out.println("\nTotal value of orders: $" + totalValue);

            System.out.println("\nDo you want to proceed with shipping? (yes/no)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                return;
            }

            // Save and load orders to and from a file
            shipProcessing.saveOrdersToFile("orders.txt");
            shipProcessing.loadOrdersFromFile("orders.txt");
            System.out.println("\nOrders after loading from file:");
            shipProcessing.printOrders();

            // Do not close the scanner here to avoid affecting the BasicPortfolio app
        } catch (ShipProcessingException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        runShipping(false, new Scanner(System.in)); // Default to non-international for the main method
    }
}
