package hexlet.code.formatters;

import java.util.Map;

import static hexlet.code.DiffComparator.ADDED;
import static hexlet.code.DiffComparator.CHANGE;
import static hexlet.code.DiffComparator.DELETED;
import static hexlet.code.DiffComparator.UNMODIFIED;
import static hexlet.code.DiffComparator.REPLACEMENT;

public class Plain {

    public static String resultProcessing(Map<String, String> isMap) {
        StringBuilder mapString = new StringBuilder();
        String text = "Property '";

        var entries = isMap.entrySet();
        for (var entry : entries) {
            String newKey = keyProcessing(entry.getKey());

            if (newKey.equals("")) {
                continue;
            } else if (newKey.contains("updated")) {
                mapString.append("\n"
                        + text + keyProcessing(entry.getKey())
                        + String.valueOf(valueProcessing(entry.getValue()))
                        + " to ");

            } else if (newKey.contains("removed")) {
                mapString.append("\n"
                        + text
                        + keyProcessing(entry.getKey()));

            } else if (newKey.contains("#$")) {
                String newValue = String.valueOf(valueProcessing(entry.getValue()));
                mapString.append(newValue);

            } else {
                mapString.append("\n"
                        + text
                        + keyProcessing(entry.getKey())
                        + String.valueOf(valueProcessing(entry.getValue())));
            }
        }
        String mapToString = mapString.toString().trim();

        return mapToString;
    }

    public static String keyProcessing(String key) {
        String getKey = null;
        String text2 = "' was updated. From ";
        String text3 = "' was removed";
        String text4 = "' was added with value: ";

        if (key.startsWith(ADDED)) {
            getKey = key.substring(ADDED.length()) + text4;

        } else if (key.startsWith(REPLACEMENT)) {
            getKey = "#$";

        } else if (key.startsWith(DELETED)) {
            getKey = key.substring(DELETED.length()) + text3;

        } else if (key.startsWith(UNMODIFIED)) {
            getKey = "";

        } else if (key.startsWith(CHANGE)) {
            getKey = key.substring(CHANGE.length()) + text2;
        }

        return getKey;
    }

    public static Object valueProcessing(Object value) {
        Object getValue;

        if (value.equals("null")) {
            getValue = value;
        } else if (value instanceof String) {
            getValue = "'" + value + "'";
        } else if (value instanceof Boolean || value instanceof Integer) {
            getValue = value;
        } else {
            getValue = "[complex value]";
        }

        return getValue;
    }
}
