package Interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static void main(String[] args) {

        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 3, 2, 7, 8, 9, 2, 4, 7, 8, 9, 10);
        Set<Integer> collect = new HashSet<>(intList);
        System.out.println(collect);

        int [] intArr={1, 10,2,7,1,0,8, 3, 4, 5, 6, 7, 3, 2, 7, 8, 9, 2, 4, 7, 8, 9, 10};
        Set<Integer> collect1 = Arrays.stream(intArr).boxed().collect(Collectors.toSet());
        System.out.println(collect1);
    }
}
