package lc238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftX = new int[nums.length + 1];
        int[] rightX = new int[nums.length + 1];
        int[] result = new int[nums.length];

        leftX[0] = 1;
        rightX[nums.length] = 1;

        for (int i = 1; i <= nums.length; i++) {
            leftX[i] = leftX[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            rightX[i] = rightX[i + 1] * nums[i];
        }

        for (int i = 1; i <= nums.length; i++) {
            result[i - 1] = leftX[i - 1] * rightX[i];
        }

        return result;
    }
}
