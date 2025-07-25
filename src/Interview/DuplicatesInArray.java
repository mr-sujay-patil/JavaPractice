package Interview;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicatesInArray {
    public static void main(String[] args) {
        List<String> stringList = List.of("virat", "om", "axar", "shreyas", "shubman", "jadeja","virat","rohit","axar","om");

        List<String> res=stringList.stream()
                .distinct()
                .toList();
        System.out.println(res);


    }
}
