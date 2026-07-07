package Interview;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicatesInArray {
    public static void main(String[] args) {
        List<String> stringList = List.of("virat", "om", "axar", "shreyas", "shubman", "jadeja","virat","rohit","axar","om");

        List<Map.Entry<String, Long>> listOfDuplicates = stringList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(str -> str.getValue() > 1)
                .toList();

        System.out.println(listOfDuplicates);

        //keep single occuring
        List<String> singleOccurings = stringList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(st -> st.getValue() == 1)
                .map(st -> st.getKey())
                .toList();

        System.out.println(singleOccurings);

        //Distinct items
                List<String> distinct =stringList.stream()
                .distinct()
                .toList();

        System.out.println(distinct);

    }
}
