package Interview;

import java.util.List;

public class PrintMultiplesOf {
    public static void main(String[] args) {
        List<Integer> intList = List.of(10,1, 2, 3, 4, 58, 6, 75, 3, 20, 7, 8, 9, 29, 45, 70, 8, 9, 10);
        intList.stream().filter(c->c%5==0).forEach(System.out::println);
    }
}
