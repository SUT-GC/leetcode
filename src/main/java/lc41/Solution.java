package lc41;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 1;
        }

        Map<Integer, Boolean> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            map.put(num, true);
            max = Math.max(max, num);
        }

        for (int i = 1; i <= max; i++) {
            if (!map.getOrDefault(i, false)) {
                return i;
            }
        }

        return Math.max(1, max + 1);
    }
}
