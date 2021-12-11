package hexlet.code;

import hexlet.code.Formatters.FormatPlain;
import hexlet.code.Formatters.FormatStylish;

import java.io.IOException;
import java.util.List;

public class Formatter {
    public static String choseFormat(String format, List<Difference> diffList) throws IOException {
        switch (format) {
            case "plain":
                return FormatPlain.showDiff(diffList);
            case "stylish":
            default:
                return FormatStylish.showDiff(diffList);
        }
    }
}
