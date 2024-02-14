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

public class Stylish {
    public static String resultProcessing(List<Map<String, Object>> result) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");

        for (Map<String, Object> map : result) {
            var status = map.get(STATUS).toString();
            var key = map.get(KEY);
            var value = valueNull(map.get(VALUE));
            var newValue = valueNull(map.get(NEW_VALUE));

            switch (status) {
                case UNMODIFIED:
                    stringBuilder.append("    " + key + ": " + value + "\n");
                    break;
                case ADDED:
                    stringBuilder.append("  + " + key + ": " + value + "\n");
                    break;
                case DELETED:
                    stringBuilder.append("  - " + key + ": " + value + "\n");
                    break;
                case CHANGED:
                    stringBuilder.append("  - " + key + ": " + value + "\n");
                    stringBuilder.append("  + " + key + ": " + newValue + "\n");
                    break;
                default:
                    throw new Exception("The supported status has not been detected.");
            }
        }
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
