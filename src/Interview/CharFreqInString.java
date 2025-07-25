package Interview;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CharFreqInString {
    public static void main(String[] args) {
        String test="abba-dabba-jabba";
        Map<Character, Long> collect = test.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        Map<String, Long> collect2 = Arrays.stream(test.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect2);

        String[] strArr= {"a","b","b","a","-","d","a","b","b","a","-","j","a","b","b","a","-"};

        Map<String, Long> collect1 = Arrays.stream(strArr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);
    }
}
