package Interview;

import java.util.List;
import java.util.stream.Collectors;

public class JoinStringPrefixSuffixDelimiter {
    public static void main(String[] args) {
        List<String> strArr= List.of("a", "b", "b", "a", "-", "d", "a", "b", "b", "a", "-", "j", "a", "b", "b", "a", "-");
        String collect = strArr.stream()
                .collect(Collectors.joining("-", "bb", "aa"));
        System.out.println(collect);

        List<String> list = List.of("Virat", "Gill", "Rohit", "Dhawan");
        String collect1 = list.stream()
                .map(word -> "[" + word + "]")
                .collect(Collectors.joining("-","{","}"));
        System.out.println(collect1);
    }
}
