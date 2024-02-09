package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.Parser.parser;
import static hexlet.code.Utils.getFileFormat;
import static hexlet.code.Utils.getFilePath;
import static hexlet.code.Utils.readFile;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        String fileContent1 = readFile(getFilePath(filePath1));
        String fileContent2 = readFile(getFilePath(filePath2));

        var mapFile1 = parser(fileContent1, getFileFormat(filePath1));
        var mapFile2 = parser(fileContent2, getFileFormat(filePath2));

        List<Map<String, Object>> resultMap = DiffComparator.comparator(mapFile1, mapFile2);
        String result = Formatter.choiceOfStyle(resultMap, format);

        return result;
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
