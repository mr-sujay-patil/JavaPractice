package Interview;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkFreqInString {
    public static void main(String[] args) {
        String language="java python java java sql sql java";
        Map<String, Long> collect = Arrays.stream(language.split(" "))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println(collect);
    }
}
