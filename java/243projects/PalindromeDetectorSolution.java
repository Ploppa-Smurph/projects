/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromedetectorsolution;

import java.util.Stack;

/**
 *
 * @author sturner
 */
public class PalindromeDetectorSolution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // We'll test our method here, but the implementation is below in the detectPalindrome method
        
        //create an array of strings to test
        String[] testArray = {"Racecar", "Tacocat", "A man a plan a canal Panama", "This is not a palindrome"};
        for(String test : testArray){
            System.out.println("Testing: " + test);
            if(detectPalindrome(test)){
                System.out.println("It's a palindrome");
            } else {
                System.out.println("It's not a palindrome");
            }
        }
    }
    
    public static boolean detectPalindrome(String test){
        //create a stack to store our reversed string
        Stack<Character> stack = new Stack<>();
        //sanitize the string by removing spaces and making it lower case
        test = test.toLowerCase().replace(" ", "");
        //add every character in the string to a stack
        for(char c : test.toCharArray()){
            stack.push(c);
        } //the stack will, when popping values off, represent the characters of the string in a backwards order
        
        //go through each letter in the string starting at the beginning and compare with the last item in the stack
        for(int i = 0; i < test.length(); i++){
            char c = stack.pop();
            //if the characters aren't the same, then it isn't a palindrome
            if(c != test.charAt(i)) return false;
        }
        //if you get through that loop without returning false, then it must be a palindrome
        return true;
        
        //as a note, this particular solution is O(2n), since it loops through the characters in the string twice
        //there are many ways to do this, and this probably isn't a very efficient solution
    }
    
}
