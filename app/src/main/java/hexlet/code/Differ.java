package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {

        String pathToFile = "src/main/resources/";
        String normalizedFilePath1 = pathToFile + filePath1;
        String normalizedFilePath2 = pathToFile + filePath2;
        if (filePath1.startsWith("./")) {
            normalizedFilePath1 = filePath1;
        } if (filePath2.startsWith("./")) {
            normalizedFilePath2 = filePath2;
        }

        Path path1 = Paths.get(normalizedFilePath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(normalizedFilePath2).toAbsolutePath().normalize();

        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + "' does not exist");
        } else if (!Files.exists(path2)) {
            throw new Exception("File '" + path2 + "' does not exist");
        }

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapFile1 = mapper.readValue(content1, new TypeReference<>() {
        });
        Map<String, Object> mapFile2 = mapper.readValue(content2, new TypeReference<>() {
        });
        Map<String, String> resultMap = DiffUtils.diffTest(mapFile1, mapFile2);
        String result = DiffUtils.stringOfMap(resultMap);

        return result;
    }
}
