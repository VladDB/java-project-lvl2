package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.TreeMap;

public class Parser {
    public static TreeMap<String, Object> parseMap(String format, String fileText) throws IOException {
        ObjectMapper mapper;

        if (format.equals("yaml") || format.equals("yml")) {
            mapper = new ObjectMapper(new YAMLFactory());
        } else {
            mapper = new ObjectMapper();
        }

        return mapper.readValue(fileText, TreeMap.class);
    }
}
