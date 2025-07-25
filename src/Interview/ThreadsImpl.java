package Interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsImpl {
    public static void main(String[] args) {

        //print table of 2 and 3 parallely
        Runnable r1 = () -> {
            try {
                printTable(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable r2 = () -> {
            try {
                printTable(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        //using Thread class
//        new Thread(r1).start();
//        new Thread(r2).start();

        //using Executors service
        ExecutorService service= Executors.newFixedThreadPool(2);
        service.submit(r1);
        service.submit(r2);

    }

    public static void printTable(int num) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + "*" + i + "=" + num * i);
            Thread.sleep(200);
        }
    }
}
