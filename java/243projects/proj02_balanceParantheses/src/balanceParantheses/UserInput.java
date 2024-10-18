package balanceParantheses;
import java.util.Scanner;

public class UserInput {
    private String input;

    // Constructor to get user input
    public UserInput() {
        Scanner scan = new Scanner(System.in);
        // Prompt the user for input
        System.out.println("Enter a sequence of parentheses, brackets, and curly braces below: ");
        // Read the input from the user
        this.input = scan.nextLine();
        // Close the scanner to free up resources
        scan.close();
    }

    public String getInput() {
        // Return the input string
        return input;
    }
}