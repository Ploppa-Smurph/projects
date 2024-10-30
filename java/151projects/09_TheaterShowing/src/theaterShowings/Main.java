package theaterShowings;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create screenings
        Screening screening1 = new Screening("Ninja Turtles", "10:00am", 5, 10);
        Screening screening2 = new Screening("The Goonies", "10:15am", 5, 10);
        ArrayList<Screening> screenings = new ArrayList<>();
        screenings.add(screening1);
        screenings.add(screening2);

        boolean continueSelecting = true;

        while (continueSelecting) {
            // Display available screenings
            System.out.println("Active Shows:");
            for (int i = 0; i < screenings.size(); i++) {
                System.out.println(i + ":");
                screenings.get(i).displaySeatingChart();
            }

            // Ask the user to choose a screening
            System.out.print("Which showing do you want to see? Select the number to choose: ");
            int chosenScreening = scanner.nextInt();

            // Ask the user to choose a seat
            System.out.print("Enter the row you want: ");
            int row = scanner.nextInt();
            System.out.print("Enter the column you want: ");
            int column = scanner.nextInt();

            // Reserve the seat and display the updated seating chart
            if (screenings.get(chosenScreening).reserveSeat(row, column)) {
                System.out.println("Seat reserved, here's the updated chart:");
            } else {
                System.out.println("Seat not available or doesn't exist.");
            }
            screenings.get(chosenScreening).displaySeatingChart();

            // Ask if the user wants to select another seat
            System.out.print("Do you want to select another seat? Enter Y for yes, anything else for no: ");
            String response = scanner.next();
            continueSelecting = response.equalsIgnoreCase("Y");
        }

        scanner.close();
    }
}