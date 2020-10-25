package lc763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public List<Integer> partitionLabels(String S) {
        if (null == S || S.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> splits = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            Character character = S.charAt(i);
            map.put(character, findLastIndex(character, S, i));
        }

        int start = 0;
        while (start < S.length()) {
            int end = start + 1;
            for (int i = start; i < end; i++) {
                Character character = S.charAt(i);
                end = Math.max(map.get(character) + 1, end);
            }

            splits.add(S.substring(start, end));
            start = end;
        }

        return splits.stream().map(String::length).collect(Collectors.toList());
    }

    private int findLastIndex(Character character, String str, int start) {
        int last = start;

        for (int i = start + 1; i < str.length(); i++) {
            if (str.charAt(i) == character) {
                last = i;
            }
        }

        return last;
    }

}
