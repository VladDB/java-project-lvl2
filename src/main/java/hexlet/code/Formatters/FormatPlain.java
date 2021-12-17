package hexlet.code.Formatters;

import hexlet.code.Difference;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class FormatPlain {
    public static String showDiff(List<Difference> diffList) {
        StringBuilder diffString = new StringBuilder();

        for (Difference oneDiff: diffList) {

            String value1 = checkValue(oneDiff.getValue1());
            String value2 = checkValue(oneDiff.getValue2());

            switch (oneDiff.getResult()) {
                case "removed":
                    diffString.append("Property ");
                    diffString.append("'" + oneDiff.getKey() + "' ");
                    diffString.append("was removed");
                    diffString.append("\n");
                    break;
                case "added":
                    diffString.append("Property ");
                    diffString.append("'" + oneDiff.getKey() + "' ");
                    diffString.append("was added with value: ");
                    diffString.append(value2);
                    diffString.append("\n");
                    break;
                case "changed":
                    diffString.append("Property ");
                    diffString.append("'" + oneDiff.getKey() + "' ");
                    diffString.append("was updated. From ");
                    diffString.append(value1 + " to " + value2);
                    diffString.append("\n");
                    break;
                case "unaltered":
                default:
                    break;
            }
        }
        return diffString.substring(0, diffString.length() - 1);
    }

    private static String checkValue(Object value) {
        if (value instanceof String) {
            if (value.equals("null")) {
                return "null";
            }
            return "'" + value + "'";
        } else if (value instanceof Collection || value instanceof Map) {
            return "[complex value]";
        } else {
            return value.toString();
        }
    }
}
