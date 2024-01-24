package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parser(String filePath, String format) throws Exception {

        if (!format.equals("json") && !format.equals("yml")) {
            throw new Exception("The file format '" + format + "' is not JSON or YAML");
        }

        if (format.equals("json")) {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> mapJson = mapper.readValue(filePath, new TypeReference<>() {
            });
            return mapJson;
        }

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Map<String, Object> mapYaml = mapper.readValue(filePath, new TypeReference<>() {
        });
        return mapYaml;
    }
}
