package hexlet.code;

import java.io.IOException;
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

    public static Path getFilePath(String filePath) throws Exception {

        Path path = Paths.get(filePath).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        return path;
    }

    public static String readFile(Path path) throws IOException {

        String content = Files.readString(path);
        return content;
    }

    public static Object valueNull(Object value) {
        if (value == null) {
            value = "null";
        }
        return value;
    }
}
