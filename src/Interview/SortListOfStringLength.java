package Interview;

import java.util.Comparator;
import java.util.List;

public class SortListOfStringLength {
    public static void main(String[] args) {
        List<String> stringList = List.of("virat", "om", "axar", "shreyas", "shubman", "jadeja");
        stringList.stream().sorted(Comparator.comparingInt(s->s.length())).forEach(System.out::println);
    }
}
