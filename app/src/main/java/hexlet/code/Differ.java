package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        Path path1;
        Path path2;

        if (!filePath1.startsWith("./")) {
            path1 = Paths.get("src/test/resources/", filePath1).toAbsolutePath().normalize();
        } else {
            path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        }
        if (!filePath2.startsWith("./")) {
            path2 = Paths.get("src/test/resources/", filePath2).toAbsolutePath().normalize();
        } else {
            path2 = Paths.get(filePath2).toAbsolutePath().normalize();
        }

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
