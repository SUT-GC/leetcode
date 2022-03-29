package lc682;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int calPoints(String[] ops) {
        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            int lastIndex = points.size() - 1;
            String o = ops[i];

            if ("+".equals(o)) {
                points.add(points.get(lastIndex - 1) + points.get(lastIndex));
            } else if ("D".equals(o)) {
                points.add(points.get(lastIndex) * 2);
            } else if ("C".equals(o)) {
                points.remove(points.size() - 1);
            } else {
                points.add(Integer.parseInt(o));
            }
        }
        return points.stream().reduce(Integer::sum).orElse(0);
    }
}
