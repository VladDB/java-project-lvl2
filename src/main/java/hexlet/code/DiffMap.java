package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiffMap {

    public static List<Difference> findDifference(TreeMap<String, Object> map1, TreeMap<String, Object> map2) {

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
