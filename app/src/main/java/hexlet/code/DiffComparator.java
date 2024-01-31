package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DiffComparator {

    public static final String ADDED = "ADDED**";
    public static final String DELETED = "DELETED**";
    public static final String REPLACEMENT = "REPLACEMENT**";
    public static final String UNMODIFIED = "UNMODIFIED**";
    public static final String CHANGED = "CHANGED**";

    public static Map<String, String> comparator(Map map1, Map map2) throws Exception {

        Map result = new LinkedHashMap<String, String>();
        var keys1 = new ArrayList<String>();
        var keys2 = new ArrayList<String>();
        keys1.addAll(map1.keySet());
        keys2.addAll(map2.keySet());
        var sortedKeys = Stream.concat(keys1.stream(), keys2.stream()).sorted().toList();

        for (var key : sortedKeys) {
            var value1 = valueNull(map1.get(key));
            var value2 = valueNull(map2.get(key));

            if (!map1.containsKey(key)) {
                result.put(ADDED + key, value2);
            } else if (!map2.containsKey(key)) {
                result.put(DELETED + key, value1);
            } else if (value1.equals(value2)) {
                result.put(UNMODIFIED + key, value1);
            } else {
                result.put(CHANGED + key, value1);
                result.put(REPLACEMENT + key, value2);
            }
        }
        return result;
    }

    public static Object valueNull(Object value) {
        if (value == null) {
            value = "null";
        }
        return value;
    }
}
