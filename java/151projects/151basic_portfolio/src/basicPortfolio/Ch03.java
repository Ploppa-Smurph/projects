package basicPortfolio;

import java.util.Scanner;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Ch03 {
    public void ch03() {

        // Portfolio Ch03 - Parse string into integer
        // use the Integer.parseInt method
        System.out.println();
        System.out.println("I created a String variable named 'need2Parse' and set it equal to 575");
        String need2Parse = "575";
        System.out.println("Using the Integer.parseInt() method I can easily parse my 'need2Parse'");
        int parsed = Integer.parseInt(need2Parse);
        System.out.println("After parsing the variable the correct integer will display... I wonder if parsing will fix my more complicated portfolio project??");
        System.out.println(parsed);

        // Portfolio Ch03 - Utilize Class or Static Method from Imported Library
        // utilizing the Math PI and Pow methods
        int radius = 15;
        double area = PI * pow(radius, 2);
        System.out.println();
        System.out.println(area);

        // Portfolio Ch03 - Define and Utilize enum
        // Created a Burgers enum and used a switch statement to describe them
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Burger Joint! What can I get for you today?");
        System.out.println("Choose a burger by typing its name (e.g., CLASSIC, CHEESEBURGER, BBQ, BREAKFAST, VEGGIE):");

        // Read user input
        // Convert to uppercase for case-insensitivity
        String userInput = scanner.nextLine().toUpperCase();

        // Parse the user input into a Burger enum value
        Burgers order;
        try {
            order = Burgers.valueOf(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Sorry, we don't have that burger on the menu. Please choose from the available options.");
            return; // Exit the program
        }

        switch (order) {
            case CLASSIC:
                System.out.println("A classic grilled burger with some condiments and pickles.");
                break;
            case CHEESEBURGER:
                System.out.println("Cheeseburgers are the most consumed food in the universe.");
                break;
            case BBQ:
                System.out.println("The BBQ burger is a southern favorite. Tangy BBQ sauce and fried onion Strings");
                break;
            case BREAKFAST:
                System.out.println("The Breakfast Burger is also known as the Hangover burger in many areas. The name precludes the movie.");
                break;
            case VEGGIE:
                System.out.println("Even a vegetarian wants to eat a hamburger sometimes.");
                break;
            default:
                System.out.println("Oops, something went wrong. Please try again.");
                break;
        }
    }
}
