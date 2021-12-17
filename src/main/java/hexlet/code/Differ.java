package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeMap;

public class Differ {

    public static String generate(String format, String file1, String file2) throws IOException {

        String formatFirstFile = fileFormat(file1);
        String formatSecondFile = fileFormat(file2);

        Path pathFirstFile = Paths.get(file1);
        Path pathSecondFile = Paths.get(file2);

        String firstFile = Files.readString(pathFirstFile);
        String secondFile = Files.readString(pathSecondFile);

        TreeMap<String, Object> map1 = Parser.parseMap(formatFirstFile, firstFile);
        TreeMap<String, Object> map2 = Parser.parseMap(formatSecondFile, secondFile);

        List<Difference> mapsDifference =  DiffMap.findDifference(map1, map2);

        return Formatter.choseFormat(format, mapsDifference);
    }

    private static String fileFormat(String file) {

        String format = "";
        int index = file.lastIndexOf(".");

        if (index > 0) {
            format = file.substring(index + 1);
        }
        return format;
    }

    public static String generate(String file1, String file2) throws IOException {
        return Differ.generate("stylish", file1, file2);
    }
}
