package Interview;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CombinedQuestions {
    public static void main(String[] args) {

        //set key and its length
        List<String> fruits = List.of("apple", "banana", "cherry");
        Map<String, Integer> collect = fruits.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(collect);


    }
}
