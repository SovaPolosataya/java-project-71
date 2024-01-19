package hexlet.code;

import java.util.*;
import java.util.stream.Stream;


public class DiffUtils {
    public static Map<String, String> diffTest(Map isMap1, Map isMap2) throws Exception {

        Map result = new LinkedHashMap<String, String>();
        var keys1 = new ArrayList<String>(isMap1.keySet());
        var keys2 = new ArrayList<String>(isMap2.keySet());
        var sortedKeys = Stream.concat(keys1.stream(), keys2.stream()).sorted().toList();

        for (var key : sortedKeys) {
            var value1 = isMap1.get(key);
            var value2 = isMap2.get(key);

            if (!isMap1.containsKey(key)) {
                result.put("+ " + key, value2);
            } else if (!isMap2.containsKey(key)) {
                result.put("- " + key, value1);
            } else if (value1.equals(value2)) {
                result.put("  " + key, value1);
            } else {
                result.put("- " + key, value1);
                result.put("+ " + key, value2);
            }
        }
        return result;
    }
    public static String stringOfMap(Map<String, String> isMap) {
        StringBuilder mapString = new StringBuilder("{" + "\n");
        var entries = isMap.entrySet();
        for (var entry : entries) {
            mapString.append(entry.getKey() + ": " + String.valueOf(entry.getValue()) + "\n");
        }
        mapString.append("}");
        String mapToString = mapString.toString();

        return mapToString;
    }
}
