package hexlet.code.formatters;

import java.util.Map;

import static hexlet.code.DiffComparator.ADDED;
import static hexlet.code.DiffComparator.CHANGED;
import static hexlet.code.DiffComparator.DELETED;
import static hexlet.code.DiffComparator.UNMODIFIED;
import static hexlet.code.DiffComparator.REPLACEMENT;

public class Plain {

    public static String resultProcessing(Map<String, String> isMap) {
        StringBuilder mapString = new StringBuilder();
        String text = "Property '";
        String text2 = "' was updated. From ";
        String text3 = "' was removed";
        String text4 = "' was added with value: ";

        var entries = isMap.entrySet();
        for (var entry : entries) {
            String startKey;

            if (entry.getKey().startsWith(UNMODIFIED)) {
                continue;

            } else if (entry.getKey().startsWith(CHANGED)) {
                startKey = CHANGED;
                mapString.append("\n"
                        + text
                        + entry.getKey().substring(startKey.length())
                        + text2
                        + String.valueOf(valueProcessing(entry.getValue()))
                        + " to ");

            } else if (entry.getKey().startsWith(REPLACEMENT)) {
                String newValue = String.valueOf(valueProcessing(entry.getValue()));
                mapString.append(newValue);

            } else if (entry.getKey().startsWith(DELETED)) {
                startKey = DELETED;
                mapString.append("\n"
                        + text
                        + entry.getKey().substring(startKey.length())
                        + text3);

            } else {
                startKey = ADDED;
                mapString.append("\n"
                        + text
                        + entry.getKey().substring(startKey.length())
                        + text4
                        + String.valueOf(valueProcessing(entry.getValue())));
            }
        }
        String mapToString = mapString.toString().trim();

        return mapToString;
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
