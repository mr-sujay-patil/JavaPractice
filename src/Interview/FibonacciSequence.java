package Interview;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciSequence {
    public static void main(String[] args) {
//        generateFibonacciSeriesTill(10);
        fibonacciUsingStream(10);
    }
//? 0,1,1,2,3,5,8,13
    public static void generateFibonacciSeriesTill(int num){
        int first=0;
        int second=1;
        for (int i=0;i<num;i++){
            int sum=first+second;
            System.out.println(first);
            first=second;
            second=sum;
        }
    }

    public static void fibonacciUsingStream(int n) {
        Stream.iterate(new int[]{0, 1}, num -> new int[]{num[1], num[0] + num[1]})
                .map(num->num[0])
                .limit(n)
                .forEach(System.out::println);
    }
}
