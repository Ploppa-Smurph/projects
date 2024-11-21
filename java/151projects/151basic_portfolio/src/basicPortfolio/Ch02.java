package basicPortfolio;

public class Ch02 {
    public void ch02() {
        System.out.println("Ch02: Mathematical Operations \n");

        // Portfolio Ch2 - Perform Mathematical equations using variables
        // ints are primative data types. they hold the actual data in memory. ints cannot be decimals
        int a = 17;
        int b = 5;
        System.out.println();
        System.out.println("if 'a' = 17, and 'b' = 5, then 'a' times 'b' is equal to " + (a * b));

        // use the parenthesis to add the 2 numbers, other concatenation will display '21' instead of 3
        System.out.println();
        System.out.println("and 2 + 1 is normally " + (2 + 1));

        // Portfolio Ch2 - Cast data from one type to another
        System.out.println();
        System.out.println("Widening casts happen automatically in Java when you assign smaller data types to larger ones.");
        int myInt = 777;
        double myDouble = myInt;                    // Widening auto cas int to double
        System.out.println(myInt);                  // output 777
        System.out.println(myDouble);               // output 777.0

        System.out.println();
        System.out.println("The user must manually accomplish a Narrowing cast conversion.");
        double myDouble2 = 9.087;
        int myInt2 = (int) myDouble2;               // manual cast from double to "(int)"
        System.out.println(myDouble2);              // output 9.087
        System.out.println(myInt2);                 // output 9

    }
}
