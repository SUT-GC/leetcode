package lc18;

import java.util.*;

public class Solution {

    public Set<String> set = new HashSet<>();

    public int[] delIAndCreatList(int[] nums, int index) {
        int[] newNums = new int[nums.length - 1];

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                continue;
            }
            newNums[j] = nums[i];
            j++;
        }

        return newNums;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 4) {
            if (nums[0] + nums[1] + nums[2] + nums[3] == target) {
                if (set.contains(String.format("%s-%s-%s-%s", nums[0], nums[1], nums[2], nums[3]))) {
                    return result;
                } else {
                    set.add(String.format("%s-%s-%s-%s", nums[0], nums[1], nums[2], nums[3]));
                }

                result.add(new ArrayList<Integer>() {{
                    add(nums[0]);
                    add(nums[1]);
                    add(nums[2]);
                    add(nums[3]);
                }});

            }
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            result.addAll(fourSum(delIAndCreatList(nums, i), target));
        }

        return result;
    }
}
