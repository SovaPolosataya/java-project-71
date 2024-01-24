package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {
    @Test
    public void testGenerateJson() throws Exception {
        String testResult = "{\n"
                +  "    chars1: [a, b, c]\n"
                +  "  - chars2: [d, e, f]\n"
                +  "  + chars2: false\n"
                +  "  - checked: false\n"
                +  "  + checked: true\n"
                +  "  - default: null\n"
                +  "  + default: [value1, value2]\n"
                +  "  - id: 45\n"
                +  "  + id: null\n"
                +  "  - key1: value1\n"
                +  "  + key2: value2\n"
                +  "    numbers1: [1, 2, 3, 4]\n"
                +  "  - numbers2: [2, 3, 4, 5]\n"
                +  "  + numbers2: [22, 33, 44, 55]\n"
                +  "  - numbers3: [3, 4, 5]\n"
                +  "  + numbers4: [4, 5, 6]\n"
                +  "  + obj1: {nestedKey=value, isNested=true}\n"
                +  "  - setting1: Some value\n"
                +  "  + setting1: Another value\n"
                +  "  - setting2: 200\n"
                +  "  + setting2: 300\n"
                +  "  - setting3: true\n"
                +  "  + setting3: none\n"
                +  "}";
        String filePath1 = "file3.json";
        String filePath2 = "file4.json";
        String format = "stylish";
        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    @Test
    public void testGenerateYml() throws Exception {
        String testResult = "{\n"
                +  "    chars1: [a, b, c]\n"
                +  "  - chars2: [d, e, f]\n"
                +  "  + chars2: false\n"
                +  "  - checked: false\n"
                +  "  + checked: true\n"
                +  "  - default: null\n"
                +  "  + default: [value1, value2]\n"
                +  "  - id: 45\n"
                +  "  + id: null\n"
                +  "  - key1: value1\n"
                +  "  + key2: value2\n"
                +  "    numbers1: [1, 2, 3, 4]\n"
                +  "  - numbers2: [2, 3, 4, 5]\n"
                +  "  + numbers2: [22, 33, 44, 55]\n"
                +  "  - numbers3: [3, 4, 5]\n"
                +  "  + numbers4: [4, 5, 6]\n"
                +  "  + obj1: {nestedKey=value, isNested=true}\n"
                +  "  - setting1: Some value\n"
                +  "  + setting1: Another value\n"
                +  "  - setting2: 200\n"
                +  "  + setting2: 300\n"
                +  "  - setting3: true\n"
                +  "  + setting3: none\n"
                +  "}";
        String filePath1 = "file3.yml";
        String filePath2 = "file4.yml";
        String format = "stylish";
        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }
    @Test
    public void testGenerateYmlAndJson() throws Exception {
        String testResult = "{\n"
                +  "    chars1: [a, b, c]\n"
                +  "  - chars2: [d, e, f]\n"
                +  "  + chars2: false\n"
                +  "  - checked: false\n"
                +  "  + checked: true\n"
                +  "  - default: null\n"
                +  "  + default: [value1, value2]\n"
                +  "  - id: 45\n"
                +  "  + id: null\n"
                +  "  - key1: value1\n"
                +  "  + key2: value2\n"
                +  "    numbers1: [1, 2, 3, 4]\n"
                +  "  - numbers2: [2, 3, 4, 5]\n"
                +  "  + numbers2: [22, 33, 44, 55]\n"
                +  "  - numbers3: [3, 4, 5]\n"
                +  "  + numbers4: [4, 5, 6]\n"
                +  "  + obj1: {nestedKey=value, isNested=true}\n"
                +  "  - setting1: Some value\n"
                +  "  + setting1: Another value\n"
                +  "  - setting2: 200\n"
                +  "  + setting2: 300\n"
                +  "  - setting3: true\n"
                +  "  + setting3: none\n"
                +  "}";
        String filePath1 = "file3.yml";
        String filePath2 = "file4.json";
        String format = "stylish";
        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }
    @Test
    public void testGenerateWithoutFormat() throws Exception {
        String testResult = "{\n"
                +  "    chars1: [a, b, c]\n"
                +  "  - chars2: [d, e, f]\n"
                +  "  + chars2: false\n"
                +  "  - checked: false\n"
                +  "  + checked: true\n"
                +  "  - default: null\n"
                +  "  + default: [value1, value2]\n"
                +  "  - id: 45\n"
                +  "  + id: null\n"
                +  "  - key1: value1\n"
                +  "  + key2: value2\n"
                +  "    numbers1: [1, 2, 3, 4]\n"
                +  "  - numbers2: [2, 3, 4, 5]\n"
                +  "  + numbers2: [22, 33, 44, 55]\n"
                +  "  - numbers3: [3, 4, 5]\n"
                +  "  + numbers4: [4, 5, 6]\n"
                +  "  + obj1: {nestedKey=value, isNested=true}\n"
                +  "  - setting1: Some value\n"
                +  "  + setting1: Another value\n"
                +  "  - setting2: 200\n"
                +  "  + setting2: 300\n"
                +  "  - setting3: true\n"
                +  "  + setting3: none\n"
                +  "}";
        String filePath1 = "file3.json";
        String filePath2 = "file4.json";
        assertEquals(testResult, Differ.generate(filePath1, filePath2));
    }
}
