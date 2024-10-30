package matineetickets;

public class MovieTicket {
    // Private variables to store the name, runtime, and cost of the movie ticket
    private String name;
    private int runtime;
    private double cost;

    // Constructor to initialize the movie ticket details
    public MovieTicket(String name, int runtime, double cost) {
        this.name = name;
        this.runtime = runtime;
        this.cost = cost;
    }

    // Method to get the price of the movie ticket
    public double getPrice() {
        return cost;
    }

    // Override the toString() method to provide a string representation of the movie ticket
    @Override
    public String toString() {
        return "Ticket for " +
                name + '\'' +
                ", runtime of " + runtime + " minutes" +
                ", cost $" + cost;
    }
}