package lc131;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        if ("".equals(s) || null == s) {
            return new ArrayList<>();
        }

        Boolean[][] dp = new Boolean[s.length()][s.length()];

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                fillDP(dp, i, j, s);
            }
        }


        return new ArrayList<>();
    }

    private void fillDP(Boolean[][] dp, int i, int j, String s) {
        if (i == j) {
            dp[i][j] = true;
        }

        if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
            dp[i][j] = true;
        }

        if (j < i) {
            dp[i][j] = null;
        }

        if (dp[i + 1][j - 1] == null) {
            fillDP(dp, i + 1, j - 1, s);
        }

        dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
    }
}
