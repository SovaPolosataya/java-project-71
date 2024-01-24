package hexlet.code.formatters;


import java.util.Map;

import static hexlet.code.DiffUtils.ADDED;
import static hexlet.code.DiffUtils.CHANGE;
import static hexlet.code.DiffUtils.DELETED;
import static hexlet.code.DiffUtils.UNMODIFIED;
import static hexlet.code.DiffUtils.UPDATED;


public class Stylish {

    public static String mapToString(Map<String, String> isMap) {
        StringBuilder mapString = new StringBuilder();
        mapString.append("{" + "\n");
        var entries = isMap.entrySet();
        for (var entry : entries) {
            mapString.append(replaceResult(entry.getKey()) + ": " + String.valueOf(entry.getValue()) + "\n");
        }
        mapString.append("}");
        String mapToString = mapString.toString();

        return mapToString;
    }

    public static String replaceResult(String key) {
        String getKey = null;
        if (key.startsWith(ADDED)) {
            getKey = "  + " + key.substring(ADDED.length());
        } else if (key.startsWith(UPDATED)) {
            getKey = "  + " + key.substring(UPDATED.length());
        } else if (key.startsWith(DELETED)) {
            getKey = "  - " + key.substring(DELETED.length());
        } else if (key.startsWith(UNMODIFIED)) {
            getKey = "    " + key.substring(UNMODIFIED.length());
        } else if (key.startsWith(CHANGE)) {
            getKey = "  - " + key.substring(CHANGE.length());
        }
        return getKey;

    }
}
