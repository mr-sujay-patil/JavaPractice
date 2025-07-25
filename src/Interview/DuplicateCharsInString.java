package Interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharsInString {

    public static void main(String[] args) {
        String str="Feedbackd";
        Map<Character,Long> mapofChar =str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println(mapofChar);

        mapofChar.entrySet()
                .stream()
                .filter(c -> (c.getValue() > 1 && str.indexOf(c.getKey())<2))
                .forEach(System.out::println);

        Set<Character> collect = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        System.out.println(collect);

    }
}
