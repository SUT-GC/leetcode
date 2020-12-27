package lc205;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (Objects.equals(s, t)) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            char sChar = sChars[i];
            char tChar = tChars[i];

            if (map.get(sChar) == null) {
                map.put(sChar, tChar);
                set.add(tChar);
                continue;
            }

            if (!Objects.equals(map.get(sChar), tChar)) {
                return false;
            }
        }


        if (set.size() != map.values().size()) {
            return false;
        }

        return true;
    }
}
