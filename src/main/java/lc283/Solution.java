package lc283;

public class Solution {
    public void moveZeroes(int[] nums) {
        if (null == nums) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        return;
    }
}
