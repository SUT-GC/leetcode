package lc287;

public class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            int cnt = 0;
            for (int num : nums) {
                cnt += num <= mid ? 1 : 0;
            }

            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
