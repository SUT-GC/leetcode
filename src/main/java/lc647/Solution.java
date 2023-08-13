package lc647;

import java.util.ArrayList;

public class Solution {
    public int countSubstrings(String s) {
        if ("".equals(s) || null == s) {
            return 0;
        }

        Boolean[][] dp = new Boolean[s.length()][s.length()];

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                fillDP(dp, i, j, s);
            }
        }

        int count = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < s.length(); i++) {
                if (dp[i][j] != null && dp[i][j]) {
                    count++;
                }
            }
        }

        return count;

    }

    private void fillDP(Boolean[][] dp, int i, int j, String s) {
        if (i == j) {
            dp[i][j] = true;
            return;
        }

        if (j - i == 1) {
            dp[i][j] = s.charAt(i) == s.charAt(j);
            return;
        }

        if (j < i) {
            dp[i][j] = null;
            return;
        }

        if (dp[i + 1][j - 1] == null) {
            fillDP(dp, i + 1, j - 1, s);
        }

        dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
        return;
    }
}
