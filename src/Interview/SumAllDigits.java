package Interview;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumAllDigits {
    public static void main(String[] args) {
        int num = 12345;

        int sum = String.valueOf(num)
                .chars()
                .map(c->c-'0')
                .sum();
        System.out.println(sum);

        int sum1 = Arrays.stream(String.valueOf(num)
                .split(""))
                .mapToInt(Integer::valueOf)
                .sum();
        System.out.println(sum1);


    }


}
