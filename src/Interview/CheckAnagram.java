package Interview;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckAnagram {
    public static void main(String[] args) {
        String strOne="silent";
        String strTwo="listen";

        String collect = Arrays.stream(strOne.split(""))
                .sorted()
                .collect(Collectors.joining());

        String collect1 = Arrays.stream(strTwo.split(""))
                .sorted()
                .collect(Collectors.joining());

        System.out.println(collect+"  "+collect1);

        if(collect.equalsIgnoreCase(collect1))
            System.out.println("Anagram");
        else
            System.out.println("Not Anagram");


//  ----------------------------------------------------------------------------------------------------

        String string1 = strOne.chars()
                .sorted()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.joining());

        String string2 = strTwo.chars()
                .sorted()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(string1+ " " +string2);

        System.out.println(string1.equals(string2) ? "Anagram" : "Not Anagram");
//  ----------------------------------------------------------------------------------------------------
        char[] charArray1 = strOne.toCharArray();
        char[] charArray2 = strTwo.toCharArray();

        System.out.println(charArray1);
        System.out.println(charArray2);

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        System.out.println(Arrays.toString(charArray1) + " " + Arrays.toString(charArray2));

        System.out.println(Arrays.equals(charArray1, charArray2) ? "Anagram" : "Not Anagram");

    }
}
