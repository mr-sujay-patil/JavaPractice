package Interview;

import java.util.stream.IntStream;

public class SplitInChunks {
    public static void main(String[] args) {
        String input = "123433343453";

        IntStream.range(0, input.length() / 3)
                .mapToObj(i -> input.substring(i * 3, i * 3 + 3))
                .forEach(System.out::println);
    }
}
