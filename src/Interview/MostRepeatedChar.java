package Interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostRepeatedChar {

    public static void main(String[] args) {
        int [] integers ={1,2,4,2,4,5,2,3,4};
        Map.Entry<Integer, Long> integerLongEntry = Arrays.stream(integers)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(c -> c.getValue()))
                .orElse(null);
        System.out.println(integerLongEntry);

        String str="absabsaddabaabaa";
        Map.Entry<String, Long> stringLongEntry = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .orElse(null);
        System.out.println(stringLongEntry);
    }
}
