package interfaceExample;

public class WalleyLinkedStack<T> implements StackInterface<T> {
    private class Node {
        // fields
        T data;
        Node next;

        // constructor
        public Node(T info) {
            data = info;
            next = null;
        }
    }

    // fields
    Node top;

    // constructor
    public WalleyLinkedStack(){
        top = null;
    }

    // methods
    @Override
    public void push(T element) {
        if(top == null) {
            top = new Node(element);
        } else {
            // create new Node
                Node newNode = new Node(element);

            // set new Node next pointer to top
                newNode.next = top;

            // make new Node the top
                top = newNode;
        }
    }

    @Override
    public T pop() {
        T result = peek();

        if(top != null)
            top = top.next;

        return result;
    }


    @Override
    public T peek() {
        if(isEmpty()) {
            return null;
        } else {
            return top.data;
        }
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

}
