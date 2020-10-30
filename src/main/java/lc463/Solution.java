package lc463;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }

                // 左边
                if (j == 0 || grid[i][j - 1] == 0) {
                    count++;
                }

                // 上边
                if (i == 0 || grid[i - 1][j] == 0) {
                    count++;
                }

                // 右边
                if (j == grid[i].length - 1 || grid[i][j + 1] == 0) {
                    count++;
                }

                // 下边
                if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
