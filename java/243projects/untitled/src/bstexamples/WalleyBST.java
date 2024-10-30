package bstexamples;

// Generic that takes object types of T and has constraints, therefore a generic that 'extends' Comparable in this example
// you can put any type in as long as that type extends 'comparable' for itself
public class WalleyBST<T extends Comparable<T>> {

    // define the node as something that holds data, also has a left and right side
    private class Node {
        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;
            this.data.compareTo(data);
        }
    }
}
