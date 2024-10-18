package balanceParantheses;

// We use the Stack utility and the charAt() method to evaluate through the inputted information
import java.util.Stack;            // import Stack utility

public class BalanceCheck {
    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
             if (ch == '{' || ch == '(' || ch == '[') {
                 stack.push(ch);
             } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                 stack.pop();
             } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                 stack.pop();
             } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                 stack.pop();
             } else if (ch == '}' || ch == ')' || ch == ']') {
                 return false; // If it's a closing bracket without a matching opening, it's not balanced
             }
        }
        return stack.isEmpty(); // If the stack is empty, all brackets were matched
    }
}
