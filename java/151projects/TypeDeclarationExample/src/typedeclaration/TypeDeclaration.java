package typedeclaration;

import java.util.Scanner;

public class TypeDeclaration {
    public static void main(String[] args) {
        // Java is a 'static' language you must assign what type of data the variable will hold.
        Scanner scan = new Scanner(System.in);

        // also is equal to a declared variable;
        Scanner scan2;                                 // by declaring the variable we allocate the memory, but have not created the object.
        scan2 = new Scanner(System.in);

    }
}
