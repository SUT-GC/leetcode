package lc3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, calLengthOfLongestSubstring(s, i));
        }

        return max;
    }

    private int calLengthOfLongestSubstring(String s, int i) {
        Set<Character> set = new HashSet<>();
        for (int j = i; j < s.length(); j++) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
            } else {
                break;
            }
        }

        return set.size();
    }
}
