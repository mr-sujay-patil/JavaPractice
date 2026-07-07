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

        //remove Duplicates
        Set<Character> collect = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        System.out.println(collect);

        Set<String> collect1 = Arrays.stream(str.split(""))
                .collect(Collectors.toSet());
        System.out.println(collect1);

    }
}
