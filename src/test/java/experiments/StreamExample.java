package experiments;

import java.util.HashMap;
import java.util.Map;

public class StreamExample {

    public void mapWithStream() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Using stream to print the map
        map.entrySet().stream()
                .forEach(entry -> System.out.println
                        (entry.getKey() + ": " + entry.getValue()));
    }

    public void mapWithoutStream() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Without using stream
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}