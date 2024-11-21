package basicPortfolio;

import basicPortfolio.ch04.MovieCollection;
import basicPortfolio.ch05.RoboWarriorExtreme;
import basicPortfolio.catfinder.CatFinder;
import basicPortfolio.ecomapp.order.OrderSite;

import java.util.Scanner;

public class BasicPortfolio {

    // Portfolio Ch1 - Write useful comments
    // Every Java program has a main() that runs the application

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("\n=== Portfolio Projects ===");
            System.out.println("1) Ch01: Print to console");
            System.out.println("2) Ch02: Mathematical operations");
            System.out.println("3) Ch03: Parsing, Importing methods, & Utilizing enums");
            System.out.println("4) Movie Collection App");
            System.out.println("5) Cat Finder App");
            System.out.println("6) RoboWarriors");
            System.out.println("7) Order Site & Shipping App");
            System.out.println("8) Quit");

            System.out.print("Enter your choice: ");
            if (scanner.hasNextLine()) { // Check if there is a line to read
                String input = scanner.nextLine();

                int choice;
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number or 'quit' to exit.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        Ch01 ch01 = new Ch01();
                        ch01.ch01();
                        break;
                    case 2:
                        Ch02 ch02 = new Ch02();
                        ch02.ch02();
                        break;
                    case 3:
                        Ch03 ch03 = new Ch03();
                        ch03.ch03();
                        break;
                    case 4:
                        MovieCollection ch04 = new MovieCollection();
                        ch04.addMoviesLoop();
                        break;
                    case 5:
                        CatFinder catFinder = new CatFinder();
                        catFinder.run();
                        break;
                    case 6:
                        RoboWarriorExtreme ch05 = new RoboWarriorExtreme();
                        ch05.start();
                        break;
                    case 7: OrderSite orderSite = new OrderSite();
                        orderSite.run(scanner);
                        break;
                    case 8:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("No input line available. Exiting.");
                quit = true;
            }
        }

        System.out.println();
        System.out.println("Exiting portfolio. Goodbye!");
    }
}
