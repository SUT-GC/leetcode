package lc242;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (Objects.equals(s, t)) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        Map<Integer, Integer> s1Map = convert(s);
        Map<Integer, Integer> t1Map = convert(t);

        return s1Map.equals(t1Map);
    }

    private Map<Integer, Integer> convert(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        s.chars().forEach(p -> {
            map.compute(p, (k, v) -> v == null ? 1 : v + 1);
        });

        return map;
    }
}
