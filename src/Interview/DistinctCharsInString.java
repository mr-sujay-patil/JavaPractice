package Interview;

import java.util.*;
import java.util.stream.Collectors;

public class DistinctCharsInString {

    public static void main(String[] args) {
        String str="Feedbackd";

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
