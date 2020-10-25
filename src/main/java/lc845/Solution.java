package lc845;

public class Solution {
    public int longestMountain(int[] A) {
        if (null == A || A.length == 0) {
            return 0;
        }

        int[] up = new int[A.length];
        int[] down = new int[A.length];

        // 填充up
        up[0] = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                up[i] = up[i - 1] + 1;
            } else {
                up[i] = 1;
            }
        }

        // 填充down
        down[A.length - 1] = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                down[i] = down[i + 1] + 1;
            } else {
                down[i] = 1;
            }
        }

        // 找出最大值
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            // 半截的山过滤掉
            if (up[i] == 1 || down[i] == 1) {
                continue;
            }

            max = Math.max(up[i] + down[i] - 1, max);
        }

        return max;
    }
}
