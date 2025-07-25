package Interview;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PractiveQuestions {
    public static void main(String[] args) {
//Find the longest string in a list of strings using Java streams:
        List<String> stringList = List.of("Johnny", "Imran", "Hritik", "Santa");
        String max = stringList.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
        System.out.println(max);

//Check if a list of integers contains a prime number using Java streams:


    }
}
