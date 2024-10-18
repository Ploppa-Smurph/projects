package queueADT;


// Array backed queue logic
public class WalleyQueue<T> implements QueueInterface<T> {
    // Fields
    private T[] innerArray;

    private int front;      // 1st slot that contains value
    private int back;       // 1st empty spot after a value
    private int counter;      // used to keep up with current

    // Constructor
    public WalleyQueue() {
        innerArray = (T[]) new Object[5];
        front = 0;
        back = 0;
        counter = 0;

    }

    // Methods
    @Override
    public void enqueue(T element) throws QueueOverflowException {
        // take element and add to back of the back

        // check to see if queue is already full using the boolean isFull()
        if (isFull()) {
            throw new QueueOverflowException();
        } else {
            // naive way to accomplish
            innerArray[back] = element;
            // take current back slot and create new back slot
            back++;
            if (back >= innerArray.length) {
                back = 0;
            }
            counter++;
        }
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        // check to see if queue is already empty
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            T value = innerArray[front];
            innerArray[front] = null;           // unnecessary step that nullifies the front value after dequeue -- it will automatically be overwritten, but this step ensures the value is 'null'
            front++;                            // increment the front forward
            if (front >= innerArray.length) {
                front = 0;
            }
            counter--;
            return value;
        }
    }

        @Override
        public boolean isFull() {
            return counter == innerArray.length;
        }

        @Override
        public boolean isEmpty () {
            return counter == 0;
        }

        @Override
        public int size () {
            return counter;
        }
    }
