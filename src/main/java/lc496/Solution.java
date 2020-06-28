package lc496;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length <= 0) {
            return nums1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] ans = new int[nums1.length];
        for (int j = 0; j < nums1.length; j++) {
            int n1i = map.get(nums1[j]);
            int bigIndex = -1;
            for (int i = n1i + 1; i < nums2.length; i++) {
                if (nums2[i] > nums1[j]) {
                    bigIndex = nums2[i];
                    break;
                }
            }

            ans[j] = bigIndex;
        }

        return ans;
    }
}
