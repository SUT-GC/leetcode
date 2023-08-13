package lc88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            m = insert(nums1, m, nums2[i]);
        }
    }

    private int insert(int[] nums1, int m, int num) {
        for (int i = 0; i < m; i++) {
            if (nums1[i] > num) {
                for (int j = m; j > i; j--) {
                    nums1[j] = nums1[j - 1];
                }

                nums1[i] = num;
                return m + 1;
            }
        }

        nums1[m] = num;

        return m + 1;
    }
}
