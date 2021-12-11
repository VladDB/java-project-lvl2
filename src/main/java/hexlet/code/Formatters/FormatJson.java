package hexlet.code.Formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Difference;

import java.io.IOException;
import java.util.List;

public class FormatJson {
    public static String showDiff(List<Difference> diffList) throws IOException {
        ObjectMapper writer = new ObjectMapper();
        return writer.writeValueAsString(diffList);
    }
}
