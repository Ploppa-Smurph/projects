package pizzaparty;

import java.util.Random;
import java.util.Scanner;

// Define an enum for Pizza Size
enum PizzaSize {
    SMALL, MEDIUM, LARGE
}

public class PizzaPartyPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Ask the user how many pizzas they want to order and convert it to an int
        System.out.print("How many pizzas do you want to order? ");
        int pizzaCount = Integer.parseInt(scanner.nextLine());

        // Request the size of the pizzas
        System.out.print("What size of pizzas would you like (small, medium, large)? ");
        String sizeInput = scanner.nextLine();

        // Convert the input string to an enum PizzaSize
        PizzaSize pizzaSize;
        if (sizeInput.equalsIgnoreCase("small")) {
            pizzaSize = PizzaSize.SMALL;
        } else if (sizeInput.equalsIgnoreCase("medium")) {
            pizzaSize = PizzaSize.MEDIUM;
        } else if (sizeInput.equalsIgnoreCase("large")) {
            pizzaSize = PizzaSize.LARGE;
        } else {
            System.out.println("Invalid size input.");
            return;
        }

        // Define a list of possible toppings
        String[] toppings = {"Pepperoni", "Mushroom", "Cheese"};

        // Choose a random topping from the array
        int randomToppingIndex = random.nextInt(toppings.length);
        String pizzaTopping = toppings[randomToppingIndex];

        // Calculate the cost based on the size of the pizza
        double pricePerPizza;
        switch (pizzaSize) {
            case SMALL:
                pricePerPizza = 6.0;
                break;
            case MEDIUM:
                pricePerPizza = 10.0;
                break;
            case LARGE:
                pricePerPizza = 14.0;
                break;
            default:
                System.out.println("Invalid pizza size.");
                return;
        }

        // Calculate the total cost before tax
        double totalCostBeforeTax = pizzaCount * pricePerPizza;

        // Calculate the tax (10% of the total cost)
        double tax = 0.10 * totalCostBeforeTax;

        // Calculate the total cost including tax
        double totalCost = totalCostBeforeTax + tax;

        // Print out the details for the user
        System.out.println("You have ordered " + pizzaCount + " pizzas of size " + sizeInput + ", topped with " +
                pizzaTopping + ".");
        System.out.printf("The total cost before tax is $%.2f%n", totalCostBeforeTax);
        System.out.printf("The tax amount is $%.2f%n", tax);
        System.out.printf("The final total cost, including tax, is $%.2f%n", totalCost);
    }
}