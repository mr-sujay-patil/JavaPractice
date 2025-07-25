package Interview;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveVovels {



    public static void main(String[] args) {
        String str="goa-elephanta-tiruvanantapuram";

//        str.chars().filter(c->!"aeiouAEIOU".contains(String.valueOf((char)c)))
//                .mapToObj(c->(char)c)
//                .forEach(System.out::print);
//
//
//        String collect = str.chars()
//                .filter(c -> !"aeiouAEIOU".contains(String.valueOf((char) c)))
//                .mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
//        System.out.println();
//        System.out.println(collect);

        String string="Alavaikuthpuram in an apple";

        Set<String> collect = Arrays.stream(string.split(" "))
                .filter(word -> word.contains("a"))
                .collect(Collectors.toSet());
        System.out.println(collect);


    }
}
