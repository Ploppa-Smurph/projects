package collectionexamples;


public class WalleyCollection<T> implements CollectionInterface<T> {
    // Fields
    T[] array = (T[]) new Object[10];
    int count = 0;                          // next empty spot in array

    // Constructor

    // Methods
    @Override
    public boolean add(T element) {
        if(!isFull()) {
            array[count] = element;
            count++;
            return true;
        } else return false;
    }

    @Override
    public T get(T target) {
       int position = find(target);
       if(position >= 0) return array[position];
       else return null;
    }

    @Override
    public boolean contains(T target) {
        return (find(target) >= 0);
    }

    @Override
    public boolean remove(T target) {
        int position = find(target);

        // check if the target is there
        if(position <0) return false;

        // if target is present swap found position with last position, then subtract 1 from count
        count--;
        array[position] = array[count];
        array[count] = null;

        return true;
    }

    @Override
    public boolean isFull() {
        return count == array.length;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    private int find(T element) {               // return the position, returns -1 if search item not found
        for(int i=0; i < count; i++) {
            if(array[i].equals(element)) return i;
        }
        return -1;
    }
}
