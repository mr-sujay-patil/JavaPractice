package Interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MergeStreams {
    public static void main(String[] args) {
        List<Integer> integers1 = List.of(12, 34, 67);
        List<Integer> integers2 = List.of(43, 62, 84);

        List<Integer> list = Stream.concat(integers1.stream(), integers2.stream()).toList();
        System.out.println(list);

        //merge sorted lists
        List<Integer> list1 = Stream.concat(integers1.stream(), integers2.stream())
                .sorted()
                .toList();
        System.out.println(list1);
    }
}
