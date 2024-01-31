package hexlet.code.formatters;

import java.util.Map;

import static hexlet.code.DiffComparator.ADDED;
import static hexlet.code.DiffComparator.CHANGED;
import static hexlet.code.DiffComparator.DELETED;
import static hexlet.code.DiffComparator.UNMODIFIED;
import static hexlet.code.DiffComparator.REPLACEMENT;

public class Stylish {
    public static String resultProcessing(Map<String, String> isMap) {
        StringBuilder mapString = new StringBuilder();
        mapString.append("{" + "\n");

        var entries = isMap.entrySet();
        for (var entry : entries) {
            mapString.append(keyProcessing(entry.getKey()) + ": " + String.valueOf(entry.getValue()) + "\n");
        }

        mapString.append("}");
        String mapToString = mapString.toString();

        return mapToString;
    }

    public static String keyProcessing(String key) {
        String getKey = null;

        if (key.startsWith(ADDED)) {
            getKey = "  + " + key.substring(ADDED.length());
        } else if (key.startsWith(REPLACEMENT)) {
            getKey = "  + " + key.substring(REPLACEMENT.length());
        } else if (key.startsWith(DELETED)) {
            getKey = "  - " + key.substring(DELETED.length());
        } else if (key.startsWith(UNMODIFIED)) {
            getKey = "    " + key.substring(UNMODIFIED.length());
        } else if (key.startsWith(CHANGED)) {
            getKey = "  - " + key.substring(CHANGED.length());
        }
        return getKey;
    }
}
