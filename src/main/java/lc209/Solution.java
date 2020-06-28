package lc209;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int sum = nums[0];

        while (i <= j) {
            if (sum >= s) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                i++;
                if (i >= nums.length) {
                    break;
                }
            } else {
                j++;
                if (j >= nums.length) {
                    break;
                }
                sum += nums[j];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
