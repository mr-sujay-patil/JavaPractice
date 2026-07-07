package Practice;

import Interview.Car;

import java.util.*;
import java.util.stream.Collectors;

public class StreamFunctions {
    public static void main(String[] args) {

        int[] intArray = {1, 3, 5, 7, -4, 2, 5, 76,7, 4, -6};
        String[] stringArray = {"sujay", "dhiraj", "ramya", "kandya", "hemant", "rohit", "nikhil", "hulya"};

        List<Integer> intList = List.of(5, 32, 5, 21, 53, 15, 76, 26, 76, 43, 33, 56);
        List<String> stringList = List.of("sujay", "dhiraj", "ramya", "kandya", "hemant", "rohit", "nikhil", "hulya");

        Car glanza=new Car("toyota", "glanza",2019);
        Car fortuner=new Car("toyota", "fortuner",2021);
        Car endeavour=new Car("ford", "endeavour",2024);
        Car verna=new Car("hyundai", "verna",2019);
        Car creta=new Car("hyundai", "creta",2019);

        List<Car> carList = List.of(glanza, fortuner, endeavour, verna, creta);

        String ay = Arrays.stream(stringArray).filter(c -> c.contains("ay")).findFirst().get();
        System.out.println(ay);

//        System.out.println(intList.stream().collect(Collectors.summarizingInt(Integer::intValue)));
        IntSummaryStatistics summary=intList.stream().collect(Collectors.summarizingInt(Integer::intValue));
//        System.out.println(summary.getAverage());

        //counting
//        System.out.println(carsList.stream().collect(Collectors.counting()));

        //partitioningBy
//        System.out.println(intList.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0)));

        //groupingBy
//        System.out.println(carsList.stream().collect(Collectors.groupingBy(Car::getBrand)));

        //groupingBy with counting
//        System.out.println(carsList.stream().collect(Collectors.groupingBy(Car::getBrand, Collectors.counting())));

        //joining
//        System.out.println(stringList.stream().collect(Collectors.joining(",","{","}")));

        //toArray
//        System.out.println(Arrays.toString(stringList.stream().filter(str -> str.contains("ya")).toArray()));

        //max
//        System.out.println(Arrays.stream(intArray).max());

        //min
//        System.out.println(intList.stream().min(Integer::compareTo));

        //findFirst
//        stringList.stream().filter(str->str.contains("ya")).findFirst().ifPresent(System.out::println);

        //findAny
//        Arrays.stream(intArray).filter(num->num<0).findAny().ifPresent(System.out::println);

        //anyMatch
//        System.out.println(Arrays.stream(intArray).anyMatch(num -> num > 0));

        //noneMatch
//        System.out.println(Arrays.stream(stringArray).noneMatch(str -> str.contains("z")));

        //allMatch
//        System.out.println(stringList.stream().allMatch(str -> str.length() > 4));

        //reduce
//        System.out.println(stringList.stream().reduce((a, b) -> a.concat(b))); //combine 2 elements and operate with next

        //collect
//        Set<Integer> uni=new HashSet<>(intList);
//        System.out.println(Arrays.stream(intArray).boxed().collect(Collectors.toSet()));

        //skip
//        intList.stream().skip(intList.size()-5).forEach(System.out::println);
//        Arrays.stream(intArray).skip(5).forEach(System.out::println);

        //limit
//        stringList.stream().map(String::toUpperCase).limit(3).forEach(System.out::println);

        //peek
//        stringList.stream().peek(s -> System.out.println(s.concat(" <-input"))).filter(str->!str.contains("ya")).map(String::toUpperCase).forEach(System.out::println);

        //sorted
//        Arrays.stream(stringArray).distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
//        Arrays.stream(intArray).distinct().sorted().forEach(System.out::print);

        //flatMap
//        List<List<String>> listOfLists= Arrays.asList(Arrays.asList(stringArray),Arrays.asList(stringArray));
//        listOfLists.stream().flatMap(Collection::stream).forEach(System.out::print);

        //Operate on List
//        IntStream.range(0, intList.size()).filter(i->i%2==0).map(intList::get).forEach(System.out::println);
//        IntStream.range(0, stringList.size()).filter(i -> i % 2 == 0).mapToObj(stringList::get).forEach(System.out::println);

        //Operate on Array
//        IntStream.range(0, intArray.length).filter(i->i%2==0).map(i->intArray[i]).forEach(System.out::println);
//        IntStream.range(0,stringArray.length).filter(i->i%2==0).mapToObj(i->stringArray[i]).forEach(System.out::println);


    }
}