package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Utils {

    public static String getFileFormat(String filePath) throws Exception {
        String format;

        int i = filePath.lastIndexOf('.');
        format = i > 0 ? filePath.substring(i + 1) : "";
        return format;
    }

    public static String getFilePath(String filePath) throws Exception {
        Path path;

        if (!filePath.startsWith("./")) {
            path = Paths.get("src", "test", "resources", filePath).toAbsolutePath().normalize();
        } else {
            path = Paths.get(filePath).toAbsolutePath().normalize();
        }

        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        String content = Files.readString(path);
        return content;
    }

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
                throw new Exception("The file format '" + format + "' is not supported.");
        }
        return newResult;
    }
}
