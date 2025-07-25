package Interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergeArrays {
    public static void main(String[] args) {
        int [] intArr={16,7,8,3,9,10};
        int [] intArr2={1,2,3,78,57,7,87};

        IntStream concatArr = IntStream.concat(Arrays.stream(intArr), Arrays.stream(intArr2));
        System.out.println(concatArr.boxed().toList());

        List<Integer> list = Stream.concat(Arrays.stream(intArr).boxed(), Arrays.stream(intArr2).boxed())
                .toList();
        System.out.println(list);

    }
}
