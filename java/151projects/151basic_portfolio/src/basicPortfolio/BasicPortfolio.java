package basicPortfolio;
import basicPortfolio.ch04.MovieCollection;
import basicPortfolio.ch05.RoboWarriorExtreme;

import java.util.Scanner;

/*
-- Jeffrey Walley | CTEC151: Java Portfolio -- very basic version | 10/11/2024
  ** I have added to the Portfolio project to include projects for Ch04 - 08 **
 */

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
            System.out.println("4) Ch04, Ch05, & Ch08: Custom Class, Encapsulation, Utilize 'if/else' structure, Complex Boolean statement, Proper use of 'for/while' loop, Read data from Scanner, and Utilizing Array/ArrayList");
            System.out.println("5) Ch06 & Ch07: Proper use of Switch statement, Create useful interface and at least 1 class that implements that interface, Create useful class with 1 overloaded method");
            System.out.println("6) Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

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
                    RoboWarriorExtreme ch05 = new RoboWarriorExtreme();
                    ch05.start();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println();
        System.out.println("Exiting portfolio. Goodbye!");
    }
}