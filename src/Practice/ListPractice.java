package Practice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListPractice {
    public static void main(String[] args) {

        List<Integer> integerList = List.of(4, 6, 4,1, 2, 10, 111,9, 0, 3,5, 8, 11,1);

//        Elements starting with "1"
//        integerList.stream().filter(p->p.toString().startsWith("1")).forEach(System.out::println);

//        Find duplicates
        Set<Integer> set=new HashSet<>();
        integerList.stream().filter(c-> !set.add(c)).forEach(System.out::println);

//        Find first element of List
//        integerList.stream().findFirst().ifPresent(System.out::println);

//        Total elements
//        long totalElem = integerList.stream().count();
//        System.out.println(totalElem);

//        Max of list
//        integerList.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);

//        Check if duplicates are present
//        Set<Integer> dups=new HashSet<>();
//        integerList.stream().filter(c -> !dups.add(c)).findFirst().ifPresentOrElse(o-> System.out.println("true"),()-> System.out.println("false"));

    }
}
