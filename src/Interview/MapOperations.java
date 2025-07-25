package Interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapOperations {

    public static void main(String[] args) {
        // Sample Maps
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Apple");
        map1.put(2, "Banana");

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(3, "Cherry");
        map2.put(4, "Date");

        // Combine both maps
        Map<Integer, String> combinedMap = new HashMap<>();
        combinedMap.putAll(map1);
        combinedMap.putAll(map2);

        // Extract keys and values into separate lists
        List<Integer> keyList = new ArrayList<>(combinedMap.keySet());
        List<String> valueList = new ArrayList<>(combinedMap.values());

        // Output
        System.out.println("Key List: " + keyList);
        System.out.println("Value List: " + valueList);
    }
}
