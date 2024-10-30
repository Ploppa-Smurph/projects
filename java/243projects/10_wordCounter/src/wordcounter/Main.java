/*
** Jeffrey Walley | CTEC243 | Proj - WordCounter | 10/30/2024
 */
package wordcounter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create an instance of WordCounter
        WordCounter wordCounter = new WordCounter();

        // Specify the filename (path to the text file)
        String filename = "./src/wordcounter/pbc.txt";

        // Read the file and populate the 'wordMap'
        wordCounter.readFile(filename);

        // Display the most frequent word and its count
        System.out.println("Most Frequent Word: " + wordCounter.getMostFrequentWord());

        // Display the least frequent word and its count
        System.out.println("Least Frequent Word: " + wordCounter.getLeastFrequentWord());

        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a word to search for its frequency
        System.out.print("Enter a word to search for its frequency: ");
        String searchWord = scanner.next();

        // Get the frequency of the entered word using WordCounter
        int frequency = wordCounter.searchWordFrequency(searchWord);

        // Display the frequency of the entered word
        System.out.println("The word '" + searchWord + "' occurs " + frequency + " times.");
    }
}
