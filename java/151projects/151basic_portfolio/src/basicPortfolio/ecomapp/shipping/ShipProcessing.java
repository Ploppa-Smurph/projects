package basicPortfolio.ecomapp.shipping;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShipProcessing {
    private List<Shipping> shippings;

    public ShipProcessing() {
        shippings = new ArrayList<>();
    }

    // Add a new shipping
    public void addOrder(Shipping shipping) throws ShipProcessingException {
        if (shipping == null) {
            throw new ShipProcessingException("Shipping cannot be null");
        }
        shippings.add(shipping);
    }

    // Save shippings to file
    public void saveOrdersToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(shippings);
        } catch (IOException e) {
            System.err.println("Error saving shipping: " + e.getMessage());
        }
    }

    // Load shippings from file
    public void loadOrdersFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            shippings = (List<Shipping>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading shipping: " + e.getMessage());
        }
    }

    // Recursive algorithm to calculate total value of shippings within a date range
    public double calculateTotalValueWithinDateRange(LocalDate startDate, LocalDate endDate) {
        return calculateTotalValueRecursive(shippings, startDate, endDate, 0);
    }

    private double calculateTotalValueRecursive(List<Shipping> shippings, LocalDate startDate, LocalDate endDate, int index) {
        if (index >= shippings.size()) {
            return 0.0;
        }

        Shipping shipping = shippings.get(index);
        double total = 0.0;
        if (shipping.getOrderDate().isAfter(startDate) && shipping.getOrderDate().isBefore(endDate)) {
            total = shipping.calculateTotalAmount();
        }

        return total + calculateTotalValueRecursive(shippings, startDate, endDate, index + 1);
    }

    // Print all shippings
    public void printOrders() {
        for (Shipping shipping : shippings) {
            System.out.println(shipping);
        }
    }
}
