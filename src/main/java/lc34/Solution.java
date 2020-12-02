package lc34;

public class Solution {
    private static final Integer INVALID_TAG = -1;

    public int[] searchRange(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return new int[]{INVALID_TAG, INVALID_TAG};
        }

        if (nums.length == 2 && nums[0] != nums[1]) {
            if (nums[0] == target) return new int[]{0, 0};
            if (nums[1] == target) return new int[]{1, 1};
        }

        return searchRange(nums, 0, nums.length - 1, target);
    }

    private int[] searchRange(int[] nums, int start, int end, int target) {
        int ansStart = INVALID_TAG;
        int ansEnd = INVALID_TAG;
        if (end - start <= 1 && nums[start] == target) {
            ansStart = start;
        }

        if (end - start <= 1 && nums[end] == target) {
            ansEnd = end;
        }

        if (end - start <= 1) {
            return new int[]{ansStart, ansEnd};
        }

        int mid = (start + end) / 2;
        int[] left = searchRange(nums, start, mid, target);
        int[] right = searchRange(nums, mid, end, target);

        return new int[]{findLeft(left, right), findRight(left, right)};
    }

    private int findRight(int[] left, int[] right) {
        if (right[1] != INVALID_TAG) {
            return right[1];
        }

        if (right[0] != INVALID_TAG) {
            return right[0];
        }

        if (left[1] != INVALID_TAG) {
            return left[1];
        }

        if (left[0] != INVALID_TAG) {
            return left[0];
        }

        return INVALID_TAG;
    }

    private int findLeft(int[] left, int[] right) {
        if (left[0] != INVALID_TAG) {
            return left[0];
        }

        if (left[1] != INVALID_TAG) {
            return left[1];
        }

        if (right[0] != INVALID_TAG) {
            return right[0];
        }

        if (right[1] != INVALID_TAG) {
            return right[1];
        }

        return INVALID_TAG;
    }
}
