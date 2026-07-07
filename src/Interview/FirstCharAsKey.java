package Interview;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstCharAsKey {
    public static void main(String[] args) {
        List<String> stringList = List.of("madam", "apple", "radar", "banana", "level");

        Map<Character, List<String>> collect = stringList.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));

        System.out.println(collect);
    }
}
