package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {

    private static final String PATH = "src/test/resources/fixtures/";

    @Test
    public void testGenerateJson() throws Exception {
        String testResult = readFixtures(getPathFixtures("resultStylish.txt"));

        String filePath1 = PATH + "file1.json";
        String filePath2 = PATH + "file2.json";
        String format = "stylish";

        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    @Test
    public void testGenerateYml() throws Exception {
        String testResult = readFixtures(getPathFixtures("resultStylish.txt"));

        String filePath1 = PATH + "file1.yml";
        String filePath2 = PATH + "file2.yml";
        String format = "stylish";

        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    @Test
    public void testGenerateYmlAndJson() throws Exception {
        String testResult = readFixtures(getPathFixtures("resultStylish.txt"));

        String filePath1 = PATH + "file1.yml";
        String filePath2 = PATH + "file2.json";
        String format = "stylish";

        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    @Test
    public void testGenerateWithoutFormat() throws Exception {
        String testResult = readFixtures(getPathFixtures("resultStylish.txt"));

        String filePath1 = PATH + "file1.json";
        String filePath2 = PATH + "file2.json";

        assertEquals(testResult, Differ.generate(filePath1, filePath2));
    }

    @Test
    public void testGenerateJsonPlain() throws Exception {
        String testResult = readFixtures(getPathFixtures("resultPlain.txt"));

        String filePath1 = PATH + "file1.json";
        String filePath2 = PATH + "file2.json";
        String format = "plain";

        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    @Test
    public void testGenerateYamlPlain() throws Exception {
        String testResult = readFixtures(getPathFixtures("resultPlain.txt"));

        String filePath1 = PATH + "file1.yml";
        String filePath2 = PATH + "file2.yml";
        String format = "plain";

        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    @Test
    public void testGenerateJsonOfJson() throws Exception {
        String testResult = readFixtures(getPathFixtures("resultJson.json"));

        String filePath1 = PATH + "file1.json";
        String filePath2 = PATH + "file2.json";
        String format = "json";

        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    @Test
    public void testGenerateYamlOfJson() throws Exception {
        String testResult = readFixtures(getPathFixtures("resultJson.json"));

        String filePath1 = PATH + "file1.yml";
        String filePath2 = PATH + "file2.yml";
        String format = "json";

        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    public static Path getPathFixtures(String filePath) throws Exception {

        Path path = Paths.get("src", "test", "resources", "fixtures", filePath)
                .toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        return path;
    }

    public static String readFixtures(Path path) throws Exception {
        String content = Files.readString(path);
        return content;
    }
}
