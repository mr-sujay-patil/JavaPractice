package Interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumAndAvgOfAllElements {
    public static void main(String[] args) {
        int[] integers = {5, 3, 7, 2, 8, 9, 3, 55, 8, 66, 42, 76};

        System.out.println(Arrays.stream(integers).sum());
        System.out.println(Arrays.stream(integers).average().getAsDouble());

        //sum of 1st 3 numbers

        int sum = Arrays.stream(integers)
                .limit(3)
                .sum();
        System.out.println(sum);

        //multiply 1st 3 numbers
        int i = Arrays.stream(integers)
                .limit(3)
                .reduce((a, b) -> a * b)
                .orElse(0);
        System.out.println(i);
    }
}
