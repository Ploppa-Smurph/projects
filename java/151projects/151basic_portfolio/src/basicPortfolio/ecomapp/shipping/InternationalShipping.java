package basicPortfolio.ecomapp.shipping;

import java.time.LocalDate;
import java.util.Arrays;

public class InternationalShipping extends Shipping {
    private double shippingCost;

    public InternationalShipping(int orderId, LocalDate orderDate, String[][] orderDetails, double shippingCost) {
        super(orderId, orderDate, orderDetails);
        this.shippingCost = shippingCost;
    }

    @Override
    public double calculateTotalAmount() {
        return super.calculateTotalAmount() + shippingCost;
    }

    @Override
    public String toString() {
        return "## International Order ##" +
                "\n Shipping Number = " + getOrderId() +
                "\n Date: " + getOrderDate() +
                "\n Details: " + Arrays.deepToString(getOrderDetails()) +
                "\n Shipping: "  + shippingCost +
                "\n \n Amount: " + calculateTotalAmount() +
                "\n";

    }
}
