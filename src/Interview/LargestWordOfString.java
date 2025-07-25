package Interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LargestWordOfString {
    public static void main(String[] args) {
        String str = "do bhai dono tabahii hi tabahi";

        Map<String, Long> map = Arrays.stream(str.split(" "))
                .min(Comparator.comparingInt(String::length))
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        String st=Arrays.stream(str.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
        System.out.println(st);
    }
}
