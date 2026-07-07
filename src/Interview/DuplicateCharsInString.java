package Interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharsInString {

    public static void main(String[] args) {
        String str="Feedbackd";

        String firstDuplicateChar = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() > 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println(firstDuplicateChar);

        //Distinct chars
        Set<Character> distinct = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        System.out.println(distinct);

        Set<String> distinct1 = Arrays.stream(str.split(""))
                .collect(Collectors.toSet());
        System.out.println(distinct1);

    }
}
