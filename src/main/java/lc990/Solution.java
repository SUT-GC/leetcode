package lc990;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean equationsPossible(String[] equations) {
        if (equations == null || equations.length == 0) {
            return true;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String equation : equations) {
            String start = equation.substring(0, 1);
            String end = equation.substring(equation.length() - 1);
            String method = equation.substring(1, equation.length() - 1);

            List<String> startMap = map.get(start);
            List<String> endMap = map.get(end);

            if ("==".equals(method)) {
                if (startMap != null && endMap != null) {
                    if (!startMap.contains(end) || !endMap.contains(start)) {
                        return false;
                    }
                }

                if (startMap == null && endMap == null) {
                    map.put(start, new ArrayList<String>() {{
                        add(end);
                        add(start);
                    }});
                    map.put(end, new ArrayList<String>() {{
                        add(start);
                        add(end);
                    }});
                }

                if (startMap != null && endMap == null) {
                    startMap.add(end);
                    map.put(end, new ArrayList<String>() {{
                        add(start);
                        addAll(startMap);
                    }});
                }

                if (startMap == null && endMap != null) {
                    endMap.add(start);
                    map.put(start, new ArrayList<String>() {{
                        add(end);
                        addAll(endMap);
                    }});
                }
            }
        }

        for (String equation : equations) {
            String start = equation.substring(0, 1);
            String end = equation.substring(equation.length() - 1);
            String method = equation.substring(1, equation.length() - 1);

            List<String> startMap = map.get(start);
            List<String> endMap = map.get(end);

            if ("!=".equals(method)) {
                if (startMap.contains(end) && endMap.contains(start)) {
                    return false;
                }
            }
        }

        return true;
    }
}
