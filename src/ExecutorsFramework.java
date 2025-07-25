import java.util.concurrent.*;

public class ExecutorsFramework {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyThread thread=new MyThread();
        ExecutorService service= Executors.newFixedThreadPool(2);
        Future<String> submit = service.submit(thread);


        for (int i=0;i<10;i++){
            Thread.sleep(200);
            System.out.println("in main");
        }
        System.out.println(submit.get());
    }

}
class MyThread implements Callable<String> {

    @Override
    public String call() {
        try {
            for (int i=0;i<10;i++){
                Thread.sleep(200);
                System.out.println("in child");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "str";
    }
}