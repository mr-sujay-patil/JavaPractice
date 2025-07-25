package Interview;

import java.util.List;

public class FlatmapImplementation {

    public static void main(String[] args) {
        List<String> stringList =List.of("Koi mil java", "Java hoon na", "Dhammal", "Java bhai MBBS", "Dhol");
        List<String> singleList = stringList.stream()
                .flatMap(String::lines)
                .toList();
        System.out.println(singleList);

        List<List<String>> listOfLists = List.of(List.of("this is not fair"), List.of("but who cares"));
        List<String> concatList = listOfLists.stream()
                .flatMap(list -> list.stream())
                .toList();
        System.out.println(concatList);
    }
}
