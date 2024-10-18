/*
-- Jeffrey Walley | 09/20/24 | CTEC243 Project 05: Recursion --
-- coded with assistance from 'TutorialsPoint': https://www.tutorialspoint.com/java/util/arrays_copyofrange_short.htm
 */
package recursion;

// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        // Ask user for array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Call the method from MaxFinder class and print the result
        int largest = MaxFinder.maxElement(numbers, numbers.length);
        System.out.println("The largest element in the array is: " + largest);

        scanner.close();
    }
}