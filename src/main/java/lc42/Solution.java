package lc42;

import java.util.LinkedList;

public class Solution {
    public int trap2(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int sumArea = 0;

        for (int i = 0; i < height.length; i++) {
            int maxLeft = -1;
            int maxRight = -1;
            for (int l = i; l >= 0; l--) {
                maxLeft = Math.max(maxLeft, height[l]);
            }
            for (int r = i; r < height.length; r++) {
                maxRight = Math.max(maxRight, height[r]);
            }
            // 当前位置上能贡献的水量
            sumArea += Math.min(maxLeft, maxRight) - height[i];
        }

        return sumArea;
    }

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }


        int[] maxOfLeft = new int[height.length];
        int[] maxOfRight = new int[height.length];


        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            maxOfLeft[i] = max;
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            maxOfRight[i] = max;
        }

        int sumArea = 0;
        for (int i = 0; i < height.length; i++) {
            sumArea += Math.min(maxOfLeft[i], maxOfRight[i]) - height[i];
        }

        return sumArea;
    }
}
