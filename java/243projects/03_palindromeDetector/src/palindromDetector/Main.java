package palindromDetector;

/* Jeffrey Walley | CTEC243 wk03 - Palindrome Detector | 09/06/2024 */

public class Main {
    public static void main(String[] args) {
        String[] testStrings = Data.getTestStrings(); // Get test strings from Data class

        for (String str : testStrings) { // Loop through each string in the array
            boolean result = Test.isPalindrome(str); // Check if the string is a palindrome using Test class method
            System.out.println("\"" + str + "\" is " + (result ? "" : "not ") + "a palindrome."); // Print the result
        }
    }
}