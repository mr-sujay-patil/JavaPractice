package Interview;

import java.util.List;

public class CheckPrimeNumber {
    public static void main(String[] args) {

        List<Integer> integers = List.of(0, 1, 2, 3, 4, 6, 5, 78, 45, 23, 97, 100);
        List<Integer> primes = integers.stream()
                .filter(CheckPrimeNumber::checkPrime)
                .toList();
        System.out.println(primes);
    }

    private static boolean checkPrime(Integer c) {
        if (c <= 1) return false;
        for (int i = 2; i <= Math.sqrt(c); i++) {
            if (c % i == 0) return false;
        }
        return true;
    }

}
