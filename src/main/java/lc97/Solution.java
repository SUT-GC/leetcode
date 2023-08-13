package lc97;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    private Map<String, Boolean> cache = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        String key = s1 + "_" + s2 + "_" + s3;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int s1Len = s1.length(), s2Len = s2.length(), s3Len = s3.length();

        if (s1Len + s2Len != s3Len) {
//            System.out.printf("%s,%s,%s,%s\n", s1, s2, s3, false);
            cache.put(key, false);
            return false;
        }

        if (s1Len < 1 || s2Len < 1) {
            boolean r = (s1 + s2).equals(s3) || (s2 + s1).equals(s3);
//            System.out.printf("%s,%s,%s,%s\n", s1, s2, s3, r);
            cache.put(key, r);
            return r;
        }

        boolean r = isInterleave(s1.substring(0, s1Len - 1), s2, s3.substring(0, s3Len - 1)) && s1.charAt(s1Len - 1) == s3.charAt(s3Len - 1)
                || isInterleave(s1, s2.substring(0, s2Len - 1), s3.substring(0, s3Len - 1)) && s2.charAt(s2Len - 1) == s3.charAt(s3Len - 1);

        cache.put(key, r);
        return r;
    }
}
