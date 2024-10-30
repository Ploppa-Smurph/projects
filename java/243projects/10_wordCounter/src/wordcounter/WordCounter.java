package wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordCounter {

    // HashMap to store words and occurrence counts
    private HashMap<String, Integer> wordMap = new HashMap<>();

        // Method to read words from a file and populate wordMap
        public void readFile(String filename) {
            try (Scanner scanner = new Scanner(new File(filename))) {
                while (scanner.hasNext()) {
                    String word = scanner.next().toLowerCase(); // Convert to lowercase to ensure case insensitivity
                    if (wordMap.containsKey(word)) {
                        wordMap.replace(word, wordMap.get(word) + 1);
                    } else {
                        wordMap.put(word, 1);
                    }
                }

            // catch exception thrown by try block
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + filename); }
        }

        // Method to find and return most frequent word
        public String getMostFrequentWord() {
            Set<Map.Entry<String, Integer>> entries = wordMap.entrySet();
            String mostFrequentWord = null;
            int highestCount = 0;

            // Iterate through the entries to find word with highest count
            for (Map.Entry<String, Integer> entry : entries) {
                if (entry.getValue() > highestCount) {
                    mostFrequentWord = entry.getKey();
                    highestCount = entry.getValue();
                }
            } return mostFrequentWord + " (" + highestCount + " times)";
        }

        // Method to find and return least frequent word
        public String getLeastFrequentWord() {
            Set<Map.Entry<String, Integer>> entries = wordMap.entrySet();
            String leastFrequentWord = null;
            int lowestCount = Integer.MAX_VALUE;

            // Iterate through the entries to find word with lowest count
            for (Map.Entry<String, Integer> entry : entries) {
                if (entry.getValue() < lowestCount) {
                    leastFrequentWord = entry.getKey();
                    lowestCount = entry.getValue();
                }
            } return leastFrequentWord + " (" + lowestCount + " times)";
        }

    // Method to search for the frequency of specific word
    public int searchWordFrequency(String word) {
            return wordMap.getOrDefault(word.toLowerCase(), 0);
        }
}