package Interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class SecondLargestInArray {
    public static void main(String[] args) {

        int [] intArr={5,3,7,2,8,9,3,55,8,66,42,76};

        Integer secondLargest=Arrays.stream(intArr)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(secondLargest);
    }


}
