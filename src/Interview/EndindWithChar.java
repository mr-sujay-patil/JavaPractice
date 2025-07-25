package Interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EndindWithChar {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(34, 56, 12, 41, 62, 91, 83, 71, 56, 101, 01, 11);
        List<Integer> collect = integerList.stream()
                .filter(num -> num % 10 == 1)
                .collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> list = integerList.stream()
                .filter(num -> String.valueOf(num).contains("1"))
                .toList();
        System.out.println(list);

        List<Integer> list1 = integerList.stream()
                .filter(num -> String.valueOf(num).startsWith("1"))
                .toList();

        System.out.println(list1);
    }
}
