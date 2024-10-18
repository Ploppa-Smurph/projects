package queueADT;

public class Queues {
    public static void main(String[] args) {
        // Array backed queue
        WalleyQueue<Integer> wq = new WalleyQueue<>();
        wq.enqueue(6);
        wq.enqueue(3);
        wq.enqueue(4);
        wq.enqueue(17);

        wq.dequeue();
        wq.dequeue();

        wq.enqueue(13);
        wq.enqueue(1);
        wq.enqueue(0);

        wq.dequeue();
        wq.dequeue();

        while(!wq.isEmpty()) {
            System.out.println(wq.dequeue());                                // while not empty continue to print out the values of the enqueued elements
        }
    }
}