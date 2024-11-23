package basicPortfolio.ecomapp.shipping;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

public class Shipping implements Comparable<Shipping>, Serializable {
    private int orderId;
    private LocalDate orderDate;
    private String[][] orderDetails;           // 2D array to store product IDs, quantities, and prices

    public Shipping(int orderId, LocalDate orderDate, String[][] orderDetails) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String[][] getOrderDetails() {
        return orderDetails;
    }

    // Calculate total amount of the order
    public double calculateTotalAmount() {
        double total = 0.0;
        for (String[] detail : orderDetails) {
            int quantity = Integer.parseInt(detail[1]);
            double price = Double.parseDouble(detail[2]);
            total += quantity * price;
        }
        return total;
    }

    // Compare orders by date
    @Override
    public int compareTo(Shipping other) {
        return this.orderDate.compareTo(other.orderDate);
    }

    // Override toString method for better output readability
    @Override
    public String toString() {
        return "OrderId = " + orderId +
                "\n Date placed: " + orderDate +
                "\n Details: " + Arrays.deepToString(orderDetails) +
                "\n Amount: " + calculateTotalAmount() +
                "\n";

    }
}
