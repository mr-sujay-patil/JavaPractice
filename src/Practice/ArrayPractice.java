package Practice;

public class ArrayPractice {

    public static void main(String[] args) {

        int[] intArray = {1, 0, 45, 6, 2, 3, 3, 4, 0, 56, 7, 2, 0, 9, 10};

//        print alternative numbers in an array
//        IntStream.range(0,intArray.length).filter(index->index%2==0).map(index->intArray[index]).forEach(System.out::println);

//        Nth Largest element
//        int p=2;
//        Integer i = Arrays.stream(intArray).boxed().sorted(Comparator.reverseOrder()).skip(p).findFirst().get();
//        System.out.println(i);

//        find duplicate element in array
//        Map<Integer, Long> mapOfElem = Arrays.stream(intArray).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        Set<Map.Entry<Integer, Long>> setOfElem = mapOfElem.entrySet().stream().filter(c -> c.getValue() > 1).collect(Collectors.toSet());
//        System.out.println(setOfElem);

//        largest and smallest element of array
//        int max = Arrays.stream(intArray).max().getAsInt();
//        System.out.println(max);
//        int min = Arrays.stream(intArray).min().getAsInt();
//        System.out.println(min);

//        Move all zeros at end of array
//        int[] nonZeroArray = Arrays.stream(intArray).filter(i -> i != 0).toArray();
//        long zeroCount = Arrays.stream(intArray).filter(f -> f == 0).count();
//        int[] finalArray = IntStream.concat(Arrays.stream(nonZeroArray), Arrays.stream(new int[(int) zeroCount])).toArray();
//        System.out.println(Arrays.toString(finalArray));
    }
}
