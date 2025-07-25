package Interview;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeArraysAndSumWithoutDefaultMethod {
    public static void main(String[] args) {
        int[] intFirst = {1, 2, 6, 3};
        int[] intSecond = {4, 5, 7};
        int[] finalSum = {0};

        IntStream.concat(Arrays.stream(intFirst), Arrays.stream(intSecond))
                .forEach(e -> finalSum[0] = finalSum[0] + e);
        System.out.println(Arrays.toString(finalSum));
    }
}
