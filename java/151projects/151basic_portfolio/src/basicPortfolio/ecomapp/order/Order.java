package basicPortfolio.ecomapp.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<String> items;
    private double totalCost;

    public Order() {
        items = new ArrayList<>();
        totalCost = 0.0;
    }

    public void addItem(String item, int quantity, double cost) {
        items.add(quantity + " x " + item + " at $" + cost + " each");
        totalCost += quantity * cost;
    }

    public List<String> getItems() {
        return items;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Shipping Details:\n");
        for (String item : items) {
            orderDetails.append(item).append("\n");
        }
        orderDetails.append("Total Cost: $").append(totalCost);
        return orderDetails.toString();
    }
}
