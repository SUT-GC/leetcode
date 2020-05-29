package lc213;

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1)), rob(nums, 1, nums.length - 2));
    }

    private int rob(int[] nums, int start, int end) {
        int[] dp = new int[end - start + 1 + 2];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start]);
            start++;
        }

        return dp[dp.length - 1];
    }
}
