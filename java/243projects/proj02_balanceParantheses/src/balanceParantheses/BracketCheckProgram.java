package balanceParantheses;
import java.util.Scanner;

/** Jeff Walley | CTEC-243 Proj 02 | 08/30/24
 * Given a string of the following characters:
 * (){}[]
 * Return whether the brackets are balanced.  That is, if for every closing bracket, there was an opening bracket before.
 * A balanced series: ({{[]()}})
 * A non-balanced series: ({}}))
 * Steps to Take:
 * Go through the string
 * Add every opening bracket to a stack
 * For every closing bracket, check to make sure the matching opening bracket is in the stack, then remove it
 * If the closing bracket doesn’t have a match in the stack, or if the stack is empty, then it isn’t balanced
 */

// the Main class
public class BracketCheckProgram {
    public static void main(String[] args) {
        // Create an instance of UserInput to get input from the user
        UserInput userInput = new UserInput();
        // Get the input string from the user
        String input = userInput.getInput();
        // Create an instance of BalanceCheck to check if the brackets are balanced
        BalanceCheck balanceChecker = new BalanceCheck();
        // Check if the input string is balanced using the BalanceCheck method
        if (balanceChecker.isBalanced(input)) {
            System.out.println("The inputted bracket string is BALANCED.");
        } else {
            System.out.println("The inputted bracket string is NOT balanced.");
        }
    }
}
