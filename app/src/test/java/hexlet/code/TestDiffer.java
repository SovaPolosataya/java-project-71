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

    @Test
    public void testGenerateJsonPlain() throws Exception {
        String testResult = "Property 'chars2' was updated. From [complex value] to false\n"
            + "Property 'checked' was updated. From false to true\n"
            + "Property 'default' was updated. From null to [complex value]\n"
            + "Property 'id' was updated. From 45 to null\n"
            + "Property 'key1' was removed\n"
            + "Property 'key2' was added with value: 'value2'\n"
            + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
            + "Property 'numbers3' was removed\n"
            + "Property 'numbers4' was added with value: [complex value]\n"
            + "Property 'obj1' was added with value: [complex value]\n"
            + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
            + "Property 'setting2' was updated. From 200 to 300\n"
            + "Property 'setting3' was updated. From true to 'none'";

        String filePath1 = "file3.json";
        String filePath2 = "file4.json";
        String format = "plain";
        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }

    @Test
    public void testGenerateYamlPlain() throws Exception {
        String testResult = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";

        String filePath1 = "file3.yml";
        String filePath2 = "file4.yml";
        String format = "plain";
        assertEquals(testResult, Differ.generate(filePath1, filePath2, format));
    }
}
