package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String choiceOfStyle(Map result, String format) throws Exception {
        String newResult;

        switch (format) {
            case "stylish":
                newResult = Stylish.resultProcessing(result);
                break;
            case "plain":
                newResult = Plain.resultProcessing(result);
                break;
            case "json":
                newResult = Json.resultProcessing(result);
                break;
            default:
                throw new Exception("The format '" + format + "' is not supported.");
        }
        return newResult;
    }
}
