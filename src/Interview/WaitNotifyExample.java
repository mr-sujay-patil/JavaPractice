package Interview;

import java.util.Optional;

class SharedResource {
    synchronized void produce() throws InterruptedException {
        System.out.println("Producing...");
        wait(); // releases the lock
        System.out.println("Resumed after notify");
    }

    synchronized void consume() {
        System.out.println("Consuming...");
        notify(); // wakes up the waiting thread
    }
}
public class WaitNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            try {
                resource.produce();
            } catch (InterruptedException e) {}
        });

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(1000); // Let producer wait first
                resource.consume();
            } catch (InterruptedException e) {}
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
