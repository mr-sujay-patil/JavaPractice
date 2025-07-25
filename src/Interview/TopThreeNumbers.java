package Interview;

import java.util.Comparator;
import java.util.List;

public class TopThreeNumbers {
    public static void main(String[] args) {
        List<Integer> integers = List.of(5, 3, 7, 2, 8, 9, 3, 55, 8, 66, 42, 76);
        Integer thirdmin = integers.stream().distinct().sorted().skip(2).findFirst().get();
        System.out.println("Third Min: "+thirdmin);

        Integer thirdmax = integers.stream().distinct().sorted(Comparator.reverseOrder()).skip(2).findFirst().get();
        System.out.println("Third Max: "+thirdmax);

        integers.stream().distinct().sorted(Comparator.naturalOrder()).limit(3).forEach(System.out::println);
        integers.stream().distinct().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
    }

}
