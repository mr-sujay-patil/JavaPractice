package Interview;

import java.util.Comparator;
import java.util.List;

public class SortDecimals {
    public static void main(String[] args) {
        List<Double> doubles = List.of(3.12, 5.45, 7.4, 1.8, 9.5);

        List<Double> list = doubles.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list);
    }
}
