package lc96;

import java.util.Arrays;

class Solution {
    public int numTrees(int n) {
        int[] points = new int[n];
        for (int i = 1; i <= n; i++) {
            points[i - 1] = i;
        }

        return numTrees(points);
    }

    public int numTrees(int[] points) {
        if (points.length == 0) {
            return 0;
        }

        if (points.length == 1) {
            return 1;
        }

        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int leftResult = numTrees(Arrays.copyOfRange(points, 0, i));
            int rightResult = numTrees(Arrays.copyOfRange(points, i + 1, points.length));
            if (leftResult == 0) {
                result += rightResult;
            } else if (rightResult == 0) {
                result += leftResult;
            } else {
                result += leftResult * rightResult;
            }
        }

        return result;
    }
}