package Interview;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepChar {
    public static void main(String[] args) {
        String str="jajanxtaram-mamantaram";

//      First Repeating Char
        Map.Entry<Character, Long> firstRepeatingChar = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() > 1)
                .findFirst()
                .orElse(null);

        System.out.println(firstRepeatingChar);

//      First Non-Repeating Char
        Map.Entry<Character, Long> firstNonRepeatingChar = str.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() < 2)
                .findFirst()
                .orElse(null);
        System.out.println(firstNonRepeatingChar);
    }
}
