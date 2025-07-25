package Interview;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseWordsOfString {

    public static void main(String[] args) {
        String str="My Name Is Sujay Patil";

        String collect = Arrays.stream(str.split(" "))
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(collect);
    }
}
