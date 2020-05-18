package lc46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            List<Integer> numsList = new ArrayList<>();
            numsList.add(nums[0]);
            result.add(numsList);
        }

        for (int i = 0; i < nums.length; i++) {
            int[] subNums = subNums(nums, i);
            List<List<Integer>> permuteResult = permute(subNums);
            for (List<Integer> integers : permuteResult) {
                List<Integer> num = new ArrayList<>(nums.length);
                num.add(nums[i]);
                num.addAll(integers);
                result.add(num);
            }

        }

        return result;
    }

    private int[] subNums(int[] nums, int skip) {
        int[] result = new int[nums.length - 1];
        int resultI = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == skip) {
                continue;
            }

            result[resultI] = nums[i];
            resultI++;
        }

        return result;
    }
}
