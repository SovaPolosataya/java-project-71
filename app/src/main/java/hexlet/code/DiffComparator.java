package hexlet.code;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DiffComparator {

    public static final String ADDED = "ADDED";
    public static final String DELETED = "DELETED";
    public static final String UNMODIFIED = "UNMODIFIED";
    public static final String CHANGED = "CHANGED";
    public static final String STATUS = "STATUS";
    public static final String KEY = "KEY";
    public static final String VALUE = "VALUE";
    public static final String NEW_VALUE = "newVALUE";

    public static List<Map<String, Object>> comparator(Map map1, Map map2) throws Exception {
        List<Map<String, Object>> result = new LinkedList<>();

        Map<String, Object> allKeys = new HashMap<>();
        allKeys.putAll(map1);
        allKeys.putAll(map2);
        List<String> sortedKeys = allKeys.keySet().stream()
                                            .sorted()
                                            .toList();

        for (var key : sortedKeys) {
            Object value1 = valueNull(map1.get(key));
            Object value2 = valueNull(map2.get(key));

            if (!map1.containsKey(key)) {
                result.add(getMapForDiff(ADDED, key, value2));
            } else if (!map2.containsKey(key)) {
                result.add(getMapForDiff(DELETED, key, value1));
            } else if (map1.containsKey(key) && map2.containsKey(key)) {
                if (Objects.equals(value1, value2)) {
                    result.add(getMapForDiff(UNMODIFIED, key, value1));
                } else {
                    result.add(getMapForDiff(CHANGED, key, value1, value2));
                }
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

    public static Map<String, Object> getMapForDiff(String status, String key, Object value1, Object value2) {
        Map<String, Object> mapForResult = new LinkedHashMap<>();

        mapForResult.put(STATUS, status);
        mapForResult.put(KEY, key);
        mapForResult.put(VALUE, value1);
        mapForResult.put(NEW_VALUE, value2);

        return mapForResult;
    }

    public static Map<String, Object> getMapForDiff(String status, String key, Object value) {
        Map<String, Object> mapForResult = new LinkedHashMap<>();

        mapForResult.put(STATUS, status);
        mapForResult.put(KEY, key);
        mapForResult.put(VALUE, value);

        return mapForResult;
    }
}
