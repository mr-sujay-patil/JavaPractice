package Interview;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LengthOfEachWord {
    public static void main(String[] args) {
        String str = "Once upon a time in Mumbai";

        Map<String, Integer> collect = Arrays.stream(str.split(" "))
                .collect(Collectors.toMap(Function.identity(), word -> word.length()));
        System.out.println(collect);
    }
}
