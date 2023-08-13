package lc5;

public class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLength = 0;
        int start = 0;
        int end = 0;

        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;

                    if (r - l + 1 > maxLength) {
                        maxLength = r - l + 1;
                        start = l;
                        end = r;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
