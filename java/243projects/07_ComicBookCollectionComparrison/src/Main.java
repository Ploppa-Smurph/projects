import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
-- Jeffrey Walley | CTEC243 07- Comparing CollectionInterface ADT | 10/02/2024
    using comic books, which ties into a project I attempted in 151.
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<ComicBook> comicBooks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the title of the comic book: ");
            String title = scanner.nextLine();
            System.out.println("Enter the year of publication: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the condition (1-10): ");
            int condition = Integer.parseInt(scanner.nextLine());

            ComicBook comic = new ComicBook(title, year, condition);
            comicBooks.add(comic);

            System.out.println("Do you want to add another comic? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }

        // Adding Comic Books to the ArrayList
        comicBooks.add(new ComicBook("The Purple Spider", 1968, 8));
        comicBooks.add(new ComicBook("The Purple Spider", 1968, 4));
        comicBooks.add(new ComicBook("The Red Cape", 1985, 7));
        comicBooks.add(new ComicBook("The Blue Bouncer", 1985, 3));
        comicBooks.add(new ComicBook("The Great Avenger", 1966, 9));
        comicBooks.add(new ComicBook("Zebraman", 1968, 8));
        comicBooks.add(new ComicBook("Incredible Crisis", 1984, 7));

        // Sorting the ArrayList by condition using a custom comparator
        java.util.Collections.sort(comicBooks, new Comparator<ComicBook>() {
            public int compare(ComicBook cb1, ComicBook cb2) {
                return Integer.compare(cb1.getConditionScore(), cb2.getConditionScore());
            }
        });

        // Printing the sorted ArrayList
        for (ComicBook cb : comicBooks) {
            System.out.println(cb);
        }
        }
    }

