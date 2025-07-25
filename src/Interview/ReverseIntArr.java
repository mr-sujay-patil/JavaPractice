package Interview;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseIntArr {
    public static void main(String[] args) {
        int [] intArr={2,5,6,3,2,6,9,5,0,4,3};
        int[] array = IntStream.range(1, intArr.length).map(i -> intArr[intArr.length - i]).toArray();
        System.out.println(Arrays.toString(array));

    }
}
