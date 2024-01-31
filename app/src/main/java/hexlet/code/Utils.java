package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    public static String getFileFormat(String filePath) throws Exception {
        String format;

        int i = filePath.lastIndexOf('.');
        format = i > 0 ? filePath.substring(i + 1) : "";
        return format;
    }

    public static String getFilePath(String filePath) throws Exception {
        Path path;

        if (!filePath.contains("/")) {
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
}
