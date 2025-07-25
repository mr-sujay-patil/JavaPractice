package Interview;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlatMapImpl {

    public static void main(String[] args) {
        int [] intArr={12,34,54,23,76,3,5,67,22,57,2,4,6,7,8,9,10};

        //find possible pair that gives 12
        int target=12;

        List<int[]> list = IntStream.range(0, intArr.length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, intArr.length)
                        .mapToObj(j -> new int[]{intArr[i], intArr[j]}))
                .filter(pair -> pair[0] + pair[1] == target)
                .toList();
        list.forEach(l-> System.out.println(l[0]+" "+l[1]));
    }
}
