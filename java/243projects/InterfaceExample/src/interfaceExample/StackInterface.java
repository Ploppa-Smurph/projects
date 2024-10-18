package interfaceExample;

// the interface says what an object can do, but does not specify how it does it.

public interface StackInterface<T> {                     // the <T> makes a generic class, see previous example
    void push(T element);
    T pop();
    T peek();
    boolean isFull();
    boolean isEmpty();
}
