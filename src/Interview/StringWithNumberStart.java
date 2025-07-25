package Interview;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StringWithNumberStart {
    public static void main(String[] args) {
        List<String> str = List.of("18virat", "rohit", "10gill", "pandya", "jadeja");
//        str.stream().filter(st->Character.isDigit(st.charAt(0))).forEach(System.out::println);

        List<String> list = str.stream()
                .filter(ch -> Character.isDigit(ch.charAt(0)))
                .toList();
        System.out.println(list);
    }

}
