package Interview;

import java.util.Arrays;

public class LastElementOfArray {
    public static void main(String[] args) {
        String[] stringList = {"virat", "om", "axar", "shreyas", "shubman", "jadeja","virat","rohit","axar","om","tom"};
        System.out.println(Arrays.stream(stringList)
                .reduce((a, b) -> b)
                .get());
    }
}
