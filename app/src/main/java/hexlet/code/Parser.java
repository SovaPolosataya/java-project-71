package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parser(String content, String format) throws Exception {

        switch (format) {
            case "json" :
                ObjectMapper mapper1 = new ObjectMapper();
                return mapper1.readValue(content, new TypeReference<>() {
                });
            case "yml" :
                ObjectMapper mapper2 = new ObjectMapper(new YAMLFactory());
                return mapper2.readValue(content, new TypeReference<>() {
                });
            default:
                throw new Exception("The file format '" + format + "' is not JSON or YAML");
        }
    }
}
