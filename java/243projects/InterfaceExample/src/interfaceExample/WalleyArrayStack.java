package interfaceExample;

public class WalleyArrayStack<T> implements StackInterface<T> {
    // fields
    T[] data;   // create the generic array named 'data'

    // index variable in this program is used to always represent the top EMPTY spot of the array.
    int index;  // create the index variable to store the array location and manipulate it in our methods

    // constructor
    WalleyArrayStack() {
        data = (T[]) new Object[50];   // casting the Object array as a generic 'T' Array ->
        index = 0;                     // initialize index with a value of 0
    }

    // methods
    // Implementing methods from StackInterface interface
    @Override
    public void push(T element) {
        data[index] = element;
        index++;
    }

    @Override
    public T pop() {
        T result =  data[index - 1];    // have to create a generic variable 'result' to store the top filled item of array
        data[index - 1] = null;         // an extra step to actually overwrite as 'null' the data before incrementing the 'index' down
        index--;                        // increment back/down 1 for the new empty spot
        return result;                  // return 'result' for use in the program
    }

    @Override
    public T peek() {
        return data[index -1];                 // shows info at top empty spot
    }

    @Override
    public boolean isFull() {
        return index >= 50;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }
}
