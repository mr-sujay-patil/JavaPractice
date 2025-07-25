package Practice;

import java.util.concurrent.*;

class RunnableImpl implements Runnable {

    @Override
    public void run() {
        System.out.println("Value");
    }
}

class CallableImpl implements Callable<String>{

    @Override
    public String call(){

        return "Call";
    }
}

public class ThreadRunnableCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunnableImpl runnable=new RunnableImpl();
        CallableImpl callable=new CallableImpl();

        Thread t1=new Thread(runnable);
        t1.start();

        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Future<String> submit = executorService.submit(callable);
        String string = submit.get();
        System.out.println(string);
    }
}
