package recursionexamples;

public class RecursionExamples {
    public static void main(String[] args) {
        System.out.println(recFactAcc(5));

        int n = 5;
        int acc = n;
        while (n > 1) {
            acc = acc * (n - 1);
            n--;
        }
        System.out.println(acc);

        int[] myArray = new int[3];
        myArray[0] = 1;
        myArray[1] = 2;
        myArray[2] = 3;


        System.out.println(recursiveArrayAdd(myArray));

        System.out.println(fib(10));

        System.out.println(binarySearch(myArray, 0, 2, 3));


    }

    public static int recFactorial(int n) {
        if(n == 0 || n == 1) return 1;                   // this is the base case - we know that 0! == 1 and also that 1! == 1
        return n * recFactorial(n - 1);               // creates recursive case - the n * recFactorial(n-1) -- is like the example of '5! = 4! * 5'
    }

    public static int recFactAcc(int n, int acc) {
        if(n == 0) return acc;                           // base case for accumulator
        return recFactAcc(n-1, n * acc);         // this accumulator
    }

    public static int recFactAcc(int n) {
        return recFactAcc(n, 1);
    }

    public static int recursiveArrayAdd(int[] array, int start, int end) {
        if (start == end) return array[start];
        return array[start] + recursiveArrayAdd(array, start + 1, end);
    }
    public static int recursiveArrayAdd(int[] array) {
        return recursiveArrayAdd(array, 0, array.length - 1);
    }

    // Recursive number at n place in Fibinacci sequence
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);                   // this is an n^2 type method?? perhaps... it is NOT efficient because it grows nearly exponentially as it progresses
    }

    // recursive Binary Search
    public static int binarySearch(int[] array, int start, int end, int search) {
        int middle = (start + end) / 2;
        if(array[middle] == search) return middle;
        if(search > array[middle]) return binarySearch(array, middle + 1, end, search);
        else return binarySearch(array, start, middle - 1, search);
    }


}
