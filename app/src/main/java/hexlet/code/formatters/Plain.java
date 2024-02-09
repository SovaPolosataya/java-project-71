package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

import static hexlet.code.DiffComparator.ADDED;
import static hexlet.code.DiffComparator.CHANGED;
import static hexlet.code.DiffComparator.DELETED;
import static hexlet.code.DiffComparator.KEY;
import static hexlet.code.DiffComparator.NEW_VALUE;
import static hexlet.code.DiffComparator.STATUS;
import static hexlet.code.DiffComparator.UNMODIFIED;
import static hexlet.code.DiffComparator.VALUE;

public class Plain {
    public static String resultProcessing(List<Map<String, Object>> result) throws Exception {
        StringBuilder resultString = new StringBuilder();
        String text1 = "Property '";
        String text2 = "' was updated. From ";
        String text3 = "' was removed";
        String text4 = "' was added with value: ";

        for (Map<String, Object> map : result) {
            var status = map.get(STATUS).toString();
            var key = map.get(KEY);
            var value = map.get(VALUE);
            var newValue = map.get(NEW_VALUE);

            switch (status) {
                case UNMODIFIED:
                    break;
                case ADDED:
                    resultString.append(text1 + key + text4 + valueProcessing(value) + "\n");
                    break;
                case DELETED:
                    resultString.append(text1 + key + text3 + "\n");
                    break;
                case CHANGED:
                    resultString.append(text1 + key + text2
                            + valueProcessing(value) + " to " + valueProcessing(newValue) + "\n");
                    break;
                default:
                    throw new Exception("The supported status has not been detected.");
            }
        }
        String result1 = resultString.toString().trim();

        return result1;
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
