package lc164;

public class Solution {
    public int maximumGap(int[] nums) {
        if (null == nums || nums.length == 1) {
            return 0;
        }

        nums = sort(nums);

        return findMapGap(nums);
    }

    private int findMapGap(int[] nums) {
        int maxGap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxGap = Math.max(maxGap, nums[i + 1] - nums[i]);
        }

        return maxGap;
    }

    private int[] sort(int[] nums) {
        int maxLength = findMaxNumberLength(nums);
        int[][] bucket = new int[10][nums.length];
        int[] maxIs = new int[10];

        int loop = 0;
        while (loop < maxLength) {
            for (int i = 0; i < maxIs.length; i++) {
                maxIs[i] = 0;
            }

            for (int i = 0; i < nums.length; i++) {
                int index = (int) (nums[i] / Math.pow(10, loop)) % 10;
                bucket[index][maxIs[index]] = nums[i];
                maxIs[index]++;
            }

            int ansI = 0;

            for (int i = 0; i < bucket.length; i++) {
                for (int j = 0; j < maxIs[i]; j++) {
                    nums[ansI] = bucket[i][j];
                    ansI++;
                }

            }

            loop++;
        }

        return nums;
    }

    private int findMaxNumberLength(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        return String.valueOf(max).length();
    }
}
