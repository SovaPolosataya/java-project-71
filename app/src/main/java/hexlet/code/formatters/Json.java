package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;
import java.util.Map;

public class Json {
    public static String resultProcessing(List<Map<String, String>> result) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        //mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String mapIsJson = mapper.writeValueAsString(result);
        return mapIsJson;
    }
}
