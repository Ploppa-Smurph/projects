package basicPortfolio.ecomapp.order;

public class Item {
    private String name;
    private double basicCost;
    private double premiumCost;

    // Constructor to initialize name and basicCost
    public Item(String name, double basicCost) {
        this.name = name;
        this.basicCost = basicCost;
        this.premiumCost = basicCost * 1.75;
    }

    public String getName() {
        return name;
    }

    public double getBasicCost() {
        return basicCost;
    }

    public double getPremiumCost() {
        return premiumCost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", basicCost=" + basicCost +
                ", premiumCost=" + premiumCost +
                '}';
    }
}
