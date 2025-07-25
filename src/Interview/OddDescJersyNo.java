package Interview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OddDescJersyNo {
    public static void main(String[] args) {
        Map<Integer,String> playerJersey=new HashMap<>();
        playerJersey.put(18,"Virat Kohli");
        playerJersey.put(7,"Dhoni");
        playerJersey.put(33,"Pandya");
        playerJersey.put(10,"Rohit Sharma");
        playerJersey.put(1,"Lokesh Rahul");
        playerJersey.put(3,"Shubman Gill");

        List<String> descJerseyNo = playerJersey.entrySet()
                .stream()
                .filter(ent -> ent.getKey() % 2 != 0)
                .sorted(Map.Entry.<Integer, String>comparingByKey()
                        .reversed())
                .map(Map.Entry::getValue)
                .toList();
        System.out.println(descJerseyNo);

        List<Map.Entry<Integer, String>> list = playerJersey.entrySet()
                .stream()
                .filter(j -> j.getKey() % 2 != 0)
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .toList();


    }
}
