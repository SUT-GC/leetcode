package lc47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();

        dfs(nums, new HashSet<>(), 0, stack, res);

        return res;
    }

    private void dfs(int[] nums, Set<Integer> useIndexes, int start, LinkedList<Integer> stack, List<List<Integer>> res) {
        if (useIndexes.size() == nums.length) {
            res.add(new ArrayList<>(stack));

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !useIndexes.contains(i - 1)) {
                continue;
            }

            if (useIndexes.contains(i)) {
                continue;
            }

            useIndexes.add(i);
            stack.addLast(nums[i]);

            dfs(nums, useIndexes, start, stack, res);

            useIndexes.remove(i);
            stack.removeLast();

        }
    }
}
