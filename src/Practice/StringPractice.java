package Practice;

import java.util.*;

public class StringPractice {
    public static void main(String[] args) {

        String inputString="abbadabbajabba";

//        find first non-repeated character
//        System.out.println(inputString.chars().mapToObj(c -> (char) c)
//                //.peek(ch -> System.out.println(inputString.indexOf(ch))).peek(ch -> System.out.println(inputString.lastIndexOf(ch)))
//                .filter(ch -> inputString.indexOf(ch) == inputString.lastIndexOf(ch))
//                .findFirst().orElse(null));

//        find consecutive repeating character
        Set<Character> seen=new HashSet<>();
        System.out.println(inputString.chars().mapToObj(c -> (char) c)
                .filter(ch -> !seen.add(ch)).findFirst().orElse(null));

//        find first repeating character
//        Map<Character, Long> charMap = inputString.chars() // Convert to IntStream
//                .mapToObj(c -> (char) c) // Convert int to Character
//                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
//
//        System.out.println(charMap.entrySet().stream()
//                .filter(c -> c.getValue() > 1)
//                .map(Map.Entry::getKey).findFirst().orElse(null));


    }
}
