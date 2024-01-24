package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Map;

public class Json {

    /*public static Map<String, String> changingTheKeysInTheMap(Map<String, String> result) {
       var entries = result.entrySet();
       Map<String, String> newResult = new LinkedHashMap<>();
       for (var entry : entries) {
          newResult.put(Stylish.keyProcessing(entry.getKey()), String.valueOf(entry.getValue()));
        }
       return newResult;
    }*/

    public static String resultProcessing(Map<String, String> result) throws JsonProcessingException {
       // var newResult = changingTheKeysInTheMap(result);

        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String mapIsJson = mapper.writeValueAsString(result);
        return mapIsJson;
    }
}
