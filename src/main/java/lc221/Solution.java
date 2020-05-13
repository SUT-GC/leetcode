package lc221;

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = matrix[i][j] == '0' ? 0 : (Math.min(Math.min(i - 1 >= 0 ? dp[i - 1][j] : 0, j - 1 >= 0 ? dp[i][j - 1] : 0), i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0) + 1);
                max = Math.max(dp[i][j], max);
            }
        }

        return max * max;
    }
}