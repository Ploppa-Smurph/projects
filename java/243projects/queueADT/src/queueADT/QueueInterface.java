package queueADT;


// QueueInterface = Interface Queue was taken by default library. Renamed to QueueInterface-- this is a Java 'Interface' class
// use the <T> to make generic - so it can accept any datatype
// created RuntimeExecution Overflow and Underflow throws and classes

public interface QueueInterface<T> {
    void enqueue(T element) throws QueueOverflowException;
    T dequeue() throws QueueUnderflowException;

    boolean isFull();
    boolean isEmpty();
    int size();

}
