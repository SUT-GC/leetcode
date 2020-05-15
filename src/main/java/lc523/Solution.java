package lc523;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        int sum = 0;
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }

        for (int i = 0; i < preSum.length - 2; i++) {
            for (int j = i + 2; j < preSum.length; j++) {
                if ((preSum[j] - preSum[i]) == k || (k != 0 && (preSum[j] - preSum[i]) % k == 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}
