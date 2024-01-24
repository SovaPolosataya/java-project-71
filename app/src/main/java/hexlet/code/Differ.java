package hexlet.code;

import java.util.Map;

import static hexlet.code.Parser.parser;
import static hexlet.code.Utils.getFileFormat;
import static hexlet.code.Utils.getFilePath;


public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        String path1 = getFilePath(filePath1);
        String path2 = getFilePath(filePath2);

        var mapFile1 = parser(path1, getFileFormat(filePath1));
        var mapFile2 = parser(path2, getFileFormat(filePath2));

        Map<String, String> resultMap = DiffUtils.comparator(mapFile1, mapFile2);
        String result = Utils.changesProcessing(resultMap, format);

        return result;
    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
