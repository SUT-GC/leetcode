package lc1365;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = find(nums, i);
        }

        return ans;
    }

    private int find(int[] nums, int index) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                continue;
            }

            if (nums[i] < nums[index]) {
                ans++;
            }
        }
        return ans;
    }
}
