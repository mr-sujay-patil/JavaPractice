package Interview;

import java.util.Comparator;
import java.util.List;

public class MaxMinOfList {
    public static void main(String[] args) {
        List<Integer> intList = List.of(10, 1, 2, 3, 4, 58, 6, 75, 3, 20, 7, 0, 8, 9, 29, 45, 70, 8, 9, 10);
        System.out.println(intList.stream().max(Comparator.naturalOrder()).get());
        System.out.println(intList.stream().min(Comparator.naturalOrder()).get());
    }
}
