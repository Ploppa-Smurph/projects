package palindromDetector;
import java.util.Stack;

public class Test {
    public static boolean isPalindrome(String str) {
        // Remove spaces and convert to lowercase for simplicity
        String cleanStr = str.trim().replace(" ", "").toLowerCase();

        // Create a stack to reverse the string except the middle character if length is odd
        Stack<Character> charStack = new Stack<>();
        int midIndex = cleanStr.length() / 2; // Find the middle index

        // Push characters from the first half of the cleaned string onto the stack
        for (int i = 0; i < midIndex; i++) {
            charStack.push(cleanStr.charAt(i));
        }

        // Step 3: Compare each character in the second half with the top of the stack
        int startIndex = cleanStr.length() % 2 == 0 ? midIndex : midIndex + 1; // Adjust for odd length

        for (int i = startIndex; i < cleanStr.length(); i++) {
            if (charStack.pop() != cleanStr.charAt(i)) {
                return false; // If characters don't match, it's not a palindrome
            }
        }

        // Step 4: Return true if all characters matched during comparison
        return true;
    }
}