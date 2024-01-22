package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {
    @Test
    public void testGenerate() throws Exception {
        String testResult = "{\n"
                          +  "- follow: false\n"
                          +  "  host: hexlet.io\n"
                          +  "- proxy: 123.234.53.22\n"
                          +  "- timeout: 50\n"
                          +  "+ timeout: 20\n"
                          +  "+ verbose: true\n"
                          +  "}";
        String filePath1 = "file1.json";
        String filePath2 = "file2.json";
        assertEquals(testResult, Differ.generate(filePath1, filePath2));
    }
}
