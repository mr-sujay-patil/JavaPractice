package Interview;

import java.util.List;
import java.util.stream.IntStream;

public class RemoveAlternateChar {
    public static void main(String[] args) {
        List<Character> aList = List.of('a', 's', 'd', 'f', 'g', 'h');
        List<Character> list = IntStream.range(0, aList.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(c -> aList.get(c))
                .toList();
        System.out.println(list);

        String anomaly = "anomaly";
        List<Character> list1 = IntStream.range(0, anomaly.length())
                .filter(i -> i % 2 == 0)
                .mapToObj(c -> anomaly.charAt(c))
                .toList();
        System.out.println(list1);
    }
}
