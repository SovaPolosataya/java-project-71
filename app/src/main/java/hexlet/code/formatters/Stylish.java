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

public class Stylish {
    public static String resultProcessing(List<Map<String, Object>> result) throws Exception {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{\n");

        for (Map<String, Object> map : result) {
            var status = map.get(STATUS).toString();
            var key = map.get(KEY);
            var value = map.get(VALUE);
            var newValue = map.get(NEW_VALUE);

            switch (status) {
                case UNMODIFIED:
                    resultString.append("    " + key + ": " + value + "\n");
                    break;
                case ADDED:
                    resultString.append("  + " + key + ": " + value + "\n");
                    break;
                case DELETED:
                    resultString.append("  - " + key + ": " + value + "\n");
                    break;
                case CHANGED:
                    resultString.append("  - " + key + ": " + value + "\n");
                    resultString.append("  + " + key + ": " + newValue + "\n");
                    break;
                default:
                    throw new Exception("The supported status has not been detected.");
            }
        }
        resultString.append("}");
        String result1 = resultString.toString();

        return result1;
    }
}
