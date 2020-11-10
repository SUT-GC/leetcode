package lc31;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return;
        }

        // 全降序列，则重排
        boolean flag = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            sort(nums, 0, nums.length);
            return;
        }

        // 找巅峰 和 低谷
        int preI = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                preI = i;
                break;
            }
        }

        // 找高的
        int highI = preI;
        int highNum = Integer.MAX_VALUE;
        for (int i = preI; i < nums.length; i++) {
            if (nums[i] > nums[preI] && nums[i] <= highNum) {
                highNum = nums[i];
                highI = i;
            }
        }

        // 交换
        int temp = nums[preI];
        nums[preI] = nums[highI];
        nums[highI] = temp;

        // 将后面的重排
        sort(nums, preI + 1, nums.length);

        return;
    }

    private void sort(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
