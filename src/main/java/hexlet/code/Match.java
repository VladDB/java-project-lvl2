package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Match {

    public static String matchingFiles(String format, String file1, String file2) throws IOException {

        String formatFirstFile = fileFormat(file1);
        String formatSecondFile = fileFormat(file2);

        Path pathFirstFile = Paths.get(file1);
        Path pathSecondFile = Paths.get(file2);

        String firstFile = Files.readString(pathFirstFile);
        String secondFile = Files.readString(pathSecondFile);

        TreeMap<String, Object> map1 = Parser.parseMap(formatFirstFile, firstFile);
        TreeMap<String, Object> map2 = Parser.parseMap(formatSecondFile, secondFile);

        List<Difference> mapsDifference = findDifference(map1, map2);

        return Formatter.choseFormat(format, mapsDifference);
    }

    private static List<Difference> findDifference(TreeMap<String, Object> map1, TreeMap<String, Object> map2) {

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

    private static String fileFormat(String file) {

        String format = "";
        int index = file.lastIndexOf(".");

        if (index > 0) {
            format = file.substring(index + 1);
        }
        return format;
    }
}
