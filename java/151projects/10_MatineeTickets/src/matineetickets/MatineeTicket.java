package matineetickets;

public class MatineeTicket extends MovieTicket {
    // Private variable to store the discount for the matinee ticket
    private double discount;

    // Constructor to initialize the matinee ticket details, including the discount
    public MatineeTicket(String name, int runtime, double cost, double discount) {

        // Call the constructor of the superclass MovieTicket
        super(name, runtime, cost);
        this.discount = discount;
    }

    // Override the getPrice method to return the discounted price
    @Override
    public double getPrice() {
        return super.getPrice() - (super.getPrice() * discount);
    }

    // Override the toString method to include discount information in the string representation
    @Override
    public String toString() {
        return "Matinee ticket for " + super.toString() +
                ", discount " + (discount * 100) + "%";
    }
}