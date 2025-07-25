package Interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class NthSmallestNumber {
    public static void main(String[] args) {
        List<Integer> integers = List.of(2, 5, 3, 65, 3, 7, 0, 1);
        Integer integer = integers.stream()
                .sorted()
                .skip(3)
                .findFirst()
                .get();
        System.out.println(integer);

        int [] intArr={2, 5, 3, 65, 3, 7, 0, 1};
        Integer skip = Arrays.stream(intArr)
                .sorted()
                .skip(2)
                .findFirst()
                .getAsInt();
        System.out.println(skip);
    }
}
