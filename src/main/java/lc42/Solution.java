package lc42;

import java.util.LinkedList;

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int sumArea = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            // 如果当前位置都比左右高，则pass这根柱子
            if (height[left] < height[i] || height[right] < height[i]) {
                continue;
            }

            LinkedList<Integer> cap = new LinkedList<>();
            cap.addFirst(height[i]);
            cap.addFirst(height[left]);
            cap.addLast(height[right]);

            while (left - 1 >= 0 && height[left - 1] >= height[left]) {
                left--;
                cap.addFirst(height[left]);
            }

            while (right + 1 < height.length && height[right + 1] >= height[right]) {
                right++;
                cap.addLast(height[right]);
            }

            int minHeight = Math.min(cap.getFirst(), cap.getLast());
            if (cap.getFirst() > cap.getLast()) {
                cap.removeFirst();
                cap.addFirst(minHeight);
            } else {
                cap.removeLast();
                cap.addLast(minHeight);
            }

            int area = minHeight * cap.size();

            for (Integer c : cap) {
                area -= c;
            }

            sumArea += area;
        }

        return sumArea;
    }
}
