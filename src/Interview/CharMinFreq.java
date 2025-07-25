package Interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharMinFreq {
    public static void main(String[] args) {
        String string= "banana appllee batata";

        Map.Entry<String, Long> stringLongEntry = Arrays.stream(string.split(""))
                .filter(c -> !c.equals(" "))  //skipping gaps
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .min(Comparator.comparingLong(Map.Entry::getValue)).orElse(null);
        System.out.println(stringLongEntry);

        Map.Entry<Character, Long> characterLongEntry = string.replaceAll(" ", "")
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .min(Comparator.comparingLong(Map.Entry::getValue)).orElse(null);

        System.out.println(characterLongEntry);

    }
}
