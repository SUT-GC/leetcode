package lc205;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (Objects.equals(s, t)) {
            return true;
        }

        Set<Character> sc = new HashSet<>();
        Set<Character> tc = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            sc.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            tc.add(t.charAt(i));
        }

        return sc.size() == tc.size();
    }
}
