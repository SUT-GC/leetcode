package lc49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // corner case
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // 找出字母组
        List<List<String>> groups = findCharsGroups(strs);

        // 对每个组去重
        groups = distinct(groups);

        // 返回
        return groups;
    }

    private List<List<String>> distinct(List<List<String>> groups) {
        for (List<String> group : groups) {
            group = group.stream().distinct().collect(Collectors.toList());
        }

        return groups;
    }

    private List<List<String>> findCharsGroups(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        for (String str : strs) {
            boolean allEmpty = true;
            for (List<String> group : groups) {
                if (null != group && group.size() > 0) {
                    if (charGroupEquals(group.get(0), str)) {
                        allEmpty = false;
                        group.add(str);
                    }
                }
            }
            if (allEmpty) {
                groups.add(new ArrayList<String>() {{
                    add(str);
                }});
            }
        }

        return groups;
    }

    private boolean charGroupEquals(String a, String b) {
        if (Objects.equals(a, b)) {
            return true;
        }

        Map<Integer, Integer> mapA = new HashMap<>();
        a.chars().forEach(p -> mapA.compute(p, (k, v) -> v == null ? 1 : v + 1));


        Map<Integer, Integer> mapB = new HashMap<>();
        b.chars().forEach(p -> mapB.compute(p, (k, v) -> v == null ? 1 : v + 1));


        return Objects.equals(mapA, mapB);
    }
}
