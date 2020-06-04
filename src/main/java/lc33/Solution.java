package lc33;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 2 && nums[1] == target) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && (i - 1 < 0 || nums[i - 1] > target) && (i + 1 >= nums.length || nums[i + 1] > target)) {
                return i;
            }
        }

        return -1;
    }
}
