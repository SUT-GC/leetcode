package lc152;

public class Solution {
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            dpMax[i] = Math.max(Math.max(dpMax[i - 1] * num, dpMin[i - 1] * num), num);
            dpMin[i] = Math.min(Math.min(dpMax[i - 1] * num, dpMin[i - 1] * num), num);

            result = Math.max(dpMax[i], result);
        }

        return result;
    }
}
