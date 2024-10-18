package portfolio_comickeeper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.Scanner;

public class AddComicBook {
    public void addComicBook() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter comic book title: ");
    String title = scanner.nextLine();

    System.out.print("Enter comic volume: ");
    int vol = Integer.parseInt(scanner.nextLine());

    System.out.print("Enter issue number: ");
    int num = Integer.parseInt(scanner.nextLine());

    System.out.print("Enter Comic Condition (FAIR, VG, VF, MINT): ");
    String grade = scanner.nextLine().toUpperCase();

    // Save comic book details to a file (e.g., "comicKeeperList.txt")
    Path outputFilePath = Path.of("comicKeeperList.txt");
    try (PrintStream fileOut = new PrintStream(new FileOutputStream(outputFilePath.toFile(), true))) {
        System.setOut(fileOut);
        System.out.println("Comic Keeper has saved your list to 'comicKeeperList.txt'");
        ComicBook comicBook = new ComicBook(title, vol, num, grade);
        comicBook.displayDetails();
    } catch (IOException e) {
        System.out.println("Error saving comic book details: " + e.getMessage());
    } finally {
    scanner.close();
}
}
}