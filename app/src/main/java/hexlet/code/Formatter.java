package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public static String choiceOfStyle(List result, String format) throws Exception {

        switch (format) {
            case "stylish":
                return Stylish.resultProcessing(result);
            case "plain":
                return Plain.resultProcessing(result);
            case "json":
                return Json.resultProcessing(result);
            default:
                throw new Exception("The format '" + format + "' is not supported.");
        }
    }
}
