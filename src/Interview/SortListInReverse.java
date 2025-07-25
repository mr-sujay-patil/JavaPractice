package Interview;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortListInReverse {
    public static void main(String[] args) {
        List<Integer> intList = List.of(10,1, 2, 3, 4, 5, 6, 7, 3, 2, 7, 8, 9, 2, 4, 7, 8, 9, 10);
        List<Integer> list = intList.stream().distinct().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list);
    }
}
