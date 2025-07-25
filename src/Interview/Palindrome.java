package Interview;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Palindrome {

    public static void main(String[] args) {

        List<String> stringList = List.of("madam", "apple", "radar", "banana", "level");
        Map<String, Boolean> collect = stringList.stream()
                .collect(Collectors.toMap(word -> word,
                        word -> word.contentEquals(new StringBuilder(word).reverse())));
        System.out.println(collect);

//        String string="madams";
//
//        //java8
//        boolean res=IntStream.range(0,string.length())
//                .anyMatch(i->string.charAt(i)==string.charAt(string.length()-1-i));
//        System.out.println(res);
//
//        boolean b = checkPalindrome(string);
//        System.out.println(b);
    }

    //older way
    static boolean checkPalindrome(String str) {
        int length = str.length();

        for (int i = 0; i <= length / 2; i++) {
            if (str.charAt(i) == str.charAt(length - 1 - i))
                return true;
        }

        return false;

    }
}
