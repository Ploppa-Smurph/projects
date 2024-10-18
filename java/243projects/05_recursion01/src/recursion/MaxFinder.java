package recursion;

public class MaxFinder {

    // Method to find maximum element in an array recursively
    public static int maxElement(int[] arr, int n) {

        // Base case: if only one element then return it as largest
        if (n == 1) {
            return arr[0];

        } else {

            // Recursive step: find maximum in rest of array
            int maxRest = maxElement(java.util.Arrays.copyOfRange(arr, 1, n), n - 1);

            // Compare first element with maximum of rest and return the larger
            return Math.max(arr[0], maxRest);
        }
    }
}