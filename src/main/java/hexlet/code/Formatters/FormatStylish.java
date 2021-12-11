package hexlet.code.Formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.Difference;

import java.util.List;

public class FormatStylish {
    public static String showDiff(List<Difference> diffList) throws JsonProcessingException {
        StringBuilder diffString = new StringBuilder();
        diffString.append("{\n");

        for (Difference oneDiff: diffList) {

            String value1 = oneDiff.getValue1().toString();
            String value2 = oneDiff.getValue2().toString();
            diffString.append("  ");

            switch (oneDiff.getResult()) {
                case "removed":
                    diffString.append("- " + oneDiff.getKey());
                    diffString.append(": " + value1);
                    diffString.append("\n");
                    break;
                case "added":
                    diffString.append("+ " + oneDiff.getKey());
                    diffString.append(": " + value2);
                    diffString.append("\n");
                    break;
                case "unaltered":
                    diffString.append("  " + oneDiff.getKey());
                    diffString.append(": " + value1);
                    diffString.append("\n");
                    break;
                case "changed":
                    diffString.append("- " + oneDiff.getKey());
                    diffString.append(": " + value1);
                    diffString.append("\n");
                    diffString.append("  ");
                    diffString.append("+ " + oneDiff.getKey());
                    diffString.append(": " + value2);
                    diffString.append("\n");
                    break;
                default:
                    break;
            }
        }
        diffString.append("}");
        return diffString.toString();
    }
}
