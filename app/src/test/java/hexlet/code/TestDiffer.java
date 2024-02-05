package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {

    @Test
    public void testGenerateJson() throws Exception {
        String testResult = getFilePathFixtures("resultStylish.json");

        String filePath1 = "file1.json";
        String filePath2 = "file2.json";
        String format = "stylish";

        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    @Test
    public void testGenerateYml() throws Exception {
        String testResult = getFilePathFixtures("resultStylish.json");

        String filePath1 = "file1.yml";
        String filePath2 = "file2.yml";
        String format = "stylish";

        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    @Test
    public void testGenerateYmlAndJson() throws Exception {
        String testResult = getFilePathFixtures("resultStylish.json");

        String filePath1 = "file1.yml";
        String filePath2 = "file2.json";
        String format = "stylish";

        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    @Test
    public void testGenerateWithoutFormat() throws Exception {
        String testResult = getFilePathFixtures("resultStylish.json");

        String filePath1 = "file1.json";
        String filePath2 = "file2.json";

        assertEquals(testResult, Differ.generate(filePath1, filePath2));
    }

    @Test
    public void testGenerateJsonPlain() throws Exception {
        String testResult = getFilePathFixtures("resultPlain.json");

        String filePath1 = "file1.json";
        String filePath2 = "file2.json";
        String format = "plain";

        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    @Test
    public void testGenerateYamlPlain() throws Exception {
        String testResult = getFilePathFixtures("resultPlain.json");

        String filePath1 = "file1.yml";
        String filePath2 = "file2.yml";
        String format = "plain";

        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    @Test
    public void testGenerateJsonOfJson() throws Exception {
        String testResult = getFilePathFixtures("resultJson.json");

        String filePath1 = "file1.json";
        String filePath2 = "file2.json";
        String format = "json";

        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    @Test
    public void testGenerateYamlOfJson() throws Exception {
        String testResult = getFilePathFixtures("resultJson.json");

        String filePath1 = "file1.yml";
        String filePath2 = "file2.yml";
        String format = "json";

        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    public static String getFilePathFixtures(String filePath) throws Exception {

        Path path = Paths.get("src", "test", "resources", "fixtures", filePath)
                .toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        String content = Files.readString(path);
        return content;
    }
}
