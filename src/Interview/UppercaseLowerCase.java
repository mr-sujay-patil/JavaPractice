package Interview;

import java.util.Arrays;
import java.util.stream.Collectors;

public class UppercaseLowerCase {
    public static void main(String[] args) {
        String st="Sachin Tendulkar";

        String stringUpper = Arrays.stream(st.split(" "))
                .map(String::toUpperCase).collect(Collectors.joining());
        System.out.println(stringUpper);

        String stringLower = Arrays.stream(st.split(" "))
                .map(ch->ch.toLowerCase()+" ").collect(Collectors.joining());
        System.out.println(stringLower);
    }
}
