package matineetickets;

public class Main {
    public static void main(String[] args) {
        // Create a regular movie ticket with name, runtime, and cost
        MovieTicket regularTicket = new MovieTicket("Hal's Groovin' Castle", 148, 12.50);

        // Create a matinee movie ticket with name, runtime, cost, and discount
        MatineeTicket matineeTicket = new MatineeTicket("Hal's Groovin' Castle", 148, 12.50, 0.20);

        // Print details of the regular movie ticket
        System.out.println(regularTicket.toString());
        System.out.println("Regular Ticket Price: $" + regularTicket.getPrice());

        // Print details of the matinee movie ticket
        System.out.println(matineeTicket.toString());
        System.out.println("Matinee Ticket Price: $" + matineeTicket.getPrice());
    }
}