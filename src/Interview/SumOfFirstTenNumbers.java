package Interview;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfFirstTenNumbers {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println(sum);

        //print first 10 even numbes
        List<Integer> list = IntStream.rangeClosed(1, 100)
                .filter(d -> d % 2 == 0)
                .limit(10)
                .boxed()
                .toList();
        System.out.println(list);
    }
}
