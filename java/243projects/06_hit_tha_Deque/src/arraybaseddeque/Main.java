package arraybaseddeque;

public class Main {
    public static void main(String[] args) {
        ArrayBasedDeque<Integer> deque = new ArrayBasedDeque<>();

        // Enqueue to the front twice
        deque.enqueueFront(42);
        deque.enqueueFront(17);

        // Dequeue from the rear twice
        System.out.println("Dequeued from rear: " + deque.dequeueRear());
        System.out.println("Dequeued from rear: " + deque.dequeueRear());

        deque.enqueueRear(15);
        deque.enqueueRear(30);
        deque.enqueueRear(40);
        deque.enqueueFront(115);
        deque.enqueueFront(60);

        System.out.println("Dequeued from rear: " + deque.dequeueRear());

            // Dequeue from the rear and print until the deque is empty
            while (!deque.isEmpty()) {
                System.out.println("Dequeued from rear: " + deque.dequeueRear());
            }
        }
    }

