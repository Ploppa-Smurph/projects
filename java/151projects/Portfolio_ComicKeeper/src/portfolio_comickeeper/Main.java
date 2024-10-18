/*
*** Jeffrey Walley | CTEC151 Advanced Java | Portfolio Project: Comic Keeper - very basic comic list | 09/23/2024
 */

package portfolio_comickeeper;

import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;
        while (keepRunning) {

            System.out.println("*".repeat(80));
            System.out.println("Welcome to Jeffrey Walley's Comic Keeper");
            System.out.println("a very basic comic book list made for my Java 151 Portfolio Project");
            System.out.println("*".repeat(80));
            System.out.println("\nComic Keeper Menu");
            System.out.println("1. Add a comic book");
            System.out.println("2. List comic book collection");
            System.out.println("0. Quit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    keepRunning = false;
                    System.out.println("Thank you for using Comic Keeper!");
                } else {
                    switch (choice) {
                        case 1:
                            AddComicBook addComicBook = new AddComicBook();
                            addComicBook.addComicBook();
                            break;
                        case 2:
                            ListComicBooks listComicBooks = new ListComicBooks();
                            listComicBooks.listComicBooks();
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }

                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer choice.");
            }
        }
    }}