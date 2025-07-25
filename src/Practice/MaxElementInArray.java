package Practice;

import java.util.Arrays;
import java.util.Comparator;

public class MaxElementInArray {
    public static void main(String[] args) {
        int [] findMaxEle={3,5,3,2,4,8,9,6,0};

        int max=Arrays.stream(findMaxEle).distinct().boxed().max(Comparator.naturalOrder()).get();
        System.out.println(max);
    }
}
