package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Match {
    public static Object matchingFiles(String file1, String file2) throws IOException {
        Path pathFirstFile = Paths.get(file1);
        Path pathSecondFile = Paths.get(file2);

        String firstFile = Files.readString(pathFirstFile);
        String secondFile = Files.readString(pathSecondFile);

        ObjectMapper mapper = new ObjectMapper();

        TreeMap map1 = mapper.readValue(firstFile, TreeMap.class);
        TreeMap map2 = mapper.readValue(secondFile, TreeMap.class);

        List<Difference> mapsDifference = findDifference(map1, map2);

        return Format.showdiff(mapsDifference);
    }

    private static List<Difference> findDifference(TreeMap map1, TreeMap map2) {
        Map<String, Object> fullMap = new TreeMap<>();
        fullMap.putAll(map1);
        fullMap.putAll(map2);

        List<Difference> diffList = new ArrayList<>();

        for (Map.Entry<String, Object> step: fullMap.entrySet()) {
            String key = step.getKey();

            Object value1 = (map1.get(key) == null) ? "null" : map1.get(key);
            Object value2 = (map2.get(key) == null) ? "null" : map2.get(key);

            if (!map2.containsKey(key)) {
                diffList.add(new Difference(key, "removed", value1, value2));
            } else if (!map1.containsKey(key)) {
                diffList.add(new Difference(key, "added", value1, value2));
            } else if (value1.equals(value2)) {
                diffList.add(new Difference(key, "unaltered", value1, value2));
            } else if (!value1.equals(value2)) {
                diffList.add(new Difference(key, "changed", value1,  value2));
            }
        }
        return diffList;
    }
}
