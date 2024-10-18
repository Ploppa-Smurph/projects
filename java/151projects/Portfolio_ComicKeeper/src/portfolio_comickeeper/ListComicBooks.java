package portfolio_comickeeper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ListComicBooks {
    public static void listComicBooks() throws FileNotFoundException {

        // Specify the path to your comicKeeperList.txt file
        String filePath = "./comicKeeperList.txt";

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Print each line from the file
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}