package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;


public class DiffUtils {

    public static final String ADDED = "ADDED";
    public static final String DELETED = "DELETED";
    public static final String UPDATED = "UPDATED";
    public static final String UNMODIFIED = "UNMODIFIED";
    public static final String CHANGE = "CHANGE";
    public static Map<String, String> comparator(Map isMap1, Map isMap2) throws Exception {

        Map result = new LinkedHashMap<String, String>();
        var keys1 = new ArrayList<String>();
        var keys2 = new ArrayList<String>();
        keys1.addAll(isMap1.keySet());
        keys2.addAll(isMap2.keySet());
        var sortedKeys = Stream.concat(keys1.stream(), keys2.stream()).sorted().toList();

        for (var key : sortedKeys) {
            var value1 = isMap1.get(key);
            var value2 = isMap2.get(key);
            if (value1 == null) {
                value1 = "null";
            } else if (value2 == null) {
                value2 = "null";
            }

            if (!isMap1.containsKey(key)) {
                result.put(ADDED + key, value2);
            } else if (!isMap2.containsKey(key)) {
                result.put(DELETED + key, value1);
            } else if (value1.equals(value2)) {
                result.put(UNMODIFIED + key, value1);
            } else {
                result.put(CHANGE + key, value1);
                result.put(UPDATED + key, value2);
            }
        }
        return result;
    }

}
