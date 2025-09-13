import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapMastery {
    public void essentialMethods() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("key", 1);
        // Integer integer = map.get("key");
        // System.out.println(integer);
        // map.remove("key");
        // map.containsKey("key");
        // map.getOrDefault("key", 0);

        // map.putIfAbsent("key", 1);
        // map.computeIfAbsent("key1", k -> 0);
        // map.computeIfPresent("key", (k, v) -> v + 1);
        // map.merge("key", 1, Integer::sum);

        Set<Entry<String, Integer>> entrySet = map.entrySet();
        for (Entry<String, Integer> entry : entrySet) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ":" + value);
        }

        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
