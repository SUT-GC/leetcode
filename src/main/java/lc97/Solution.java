package lc97;

import java.util.Objects;

public class Solution {
    public boolean stringEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public boolean is_Interleave(String s1, int i, String s2, int j, String res, String s3) {
        if (res.equals(s3) && i == s1.length() && j == s2.length()) {
            return true;
        }
        boolean ans = false;
        if (i < s1.length()) {
            ans |= is_Interleave(s1, i + 1, s2, j, res + s1.charAt(i), s3);
        }
        if (j < s2.length()) {
            ans |= is_Interleave(s1, i, s2, j + 1, res + s2.charAt(j), s3);
        }
        return ans;

    }

    public boolean isInterleave3(String s1, String s2, String s3) {
        return is_Interleave(s1, 0, s2, 0, "", s3);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        if (stringEmpty(s1) && Objects.equals(s2, s3) || stringEmpty(s2) && Objects.equals(s1, s3)) {
            return true;
        }

        if (stringEmpty(s1) || stringEmpty(s2) || stringEmpty(s3)) {
            return false;
        }

        char s1c = s1.charAt(0);
        char s2c = s2.charAt(0);
        char s3c = s3.charAt(0);

        if (s1c != s3c && s2c != s3c) {
            return false;
        }

        if (s1c == s3c && s2c == s3c) {
            return isInterleave(s1.substring(1), s2, s3.substring(1)) || isInterleave(s1, s2.substring(1, s2.length()), s3.substring(1));
        }

        if (s1c == s3c) {
            return isInterleave(s1.substring(1), s2, s3.substring(1));
        }

        return isInterleave(s1, s2.substring(1), s3.substring(1));
    }
}
