package Interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SeparateEvenOdd {

    public static void main(String[] args) {

        int [] intArr={1,2,3,4,5,6,7,8,9,10};
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> collect1 = intList.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(collect1);

        Map<Boolean, List<Integer>> collect = Arrays.stream(intArr).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(collect);
    }
}
