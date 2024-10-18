package arraybaseddeque;

public class ArrayBasedDeque<T> implements DequeInterface<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int front;
    private int rear;
    private int size;

    public ArrayBasedDeque() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public void enqueueFront(T element) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException("Deque is full.");
        }
        front = (front - 1 + elements.length) % elements.length;
        elements[front] = element;
        size++;
    }

    @Override
    public void enqueueRear(T element) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException("Deque is full.");
        }
        elements[rear] = element;
        rear = (rear + 1) % elements.length;
        size++;
    }

    @Override
    public T dequeueFront() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Deque is empty.");
        }
        T removedElement = elements[front];
        front = (front + 1) % elements.length;
        size--;
        return removedElement;
    }

    @Override
    public T dequeueRear() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Deque is empty.");
        }
        rear = (rear - 1 + elements.length) % elements.length;
        T removedElement = elements[rear];
        size--;
        return removedElement;
    }

    @Override
    public boolean isFull() {
        return size == elements.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}