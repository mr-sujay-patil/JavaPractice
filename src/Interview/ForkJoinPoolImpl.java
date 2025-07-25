package Interview;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ForkJoinPoolImpl {
    public static void main(String[] args) {

        long start=System.nanoTime();
        ForkJoinPool pool=new ForkJoinPool(10);
        pool.submit(()->{
            List<Integer> list = IntStream.range(1, 10000).boxed().toList();
            int sum = list.parallelStream()
                    .mapToInt(c -> c*2)
                    .sum();
            System.out.println(sum);
        }).join();
        long end=System.nanoTime();
        System.out.println((end-start)/10000);
        pool.shutdown();

        System.out.println(Runtime.getRuntime().freeMemory());

        ForkJoinPool commonPool=ForkJoinPool.commonPool();
        commonPool.submit(()->{
            List<Integer> list = IntStream.rangeClosed(1, 20).boxed().toList();
            Integer integer = list.stream()
                    .reduce(Integer::sum).orElse(null);
//            System.out.println(integer);
        }).join();
        commonPool.shutdown();
    }
}
