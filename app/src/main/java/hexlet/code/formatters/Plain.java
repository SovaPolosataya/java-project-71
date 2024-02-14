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
import static hexlet.code.Utils.valueNull;

public class Plain {
    public static String resultProcessing(List<Map<String, Object>> result) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map<String, Object> map : result) {
            var status = map.get(STATUS).toString();
            var key = map.get(KEY);
            var value = valueNull(map.get(VALUE));
            var newValue = valueNull(map.get(NEW_VALUE));

            switch (status) {
                case UNMODIFIED:
                    break;
                case ADDED:
                    stringBuilder.append("Property '" + key + "' was added with value: "
                            + valueProcessing(value) + "\n");
                    break;
                case DELETED:
                    stringBuilder.append("Property '" + key + "' was removed" + "\n");
                    break;
                case CHANGED:
                    stringBuilder.append("Property '" + key + "' was updated. From "
                            + valueProcessing(value) + " to " + valueProcessing(newValue) + "\n");
                    break;
                default:
                    throw new Exception("The supported status has not been detected.");
            }
        }
        return stringBuilder.toString().trim();
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
