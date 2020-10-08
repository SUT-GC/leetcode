package lc75;

public class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        int i = 0;
        int maxI = nums.length - 1;

        while (true) {
            if (i == maxI & nums[i] == 2) {
                break;
            }

            if (p0 > maxI || p1 > maxI) {
                break;
            }

            if (nums[i] == 0) {
                swap(nums, p0, i);
                p0++;
            }

            if (nums[i] == 1) {
                swap(nums, p1, i);
                p1++;
            }

            if (p0 > p1) {
                p1++;
            }

            if (i < maxI) {
                i++;
            }

        }

        System.out.println(nums);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
