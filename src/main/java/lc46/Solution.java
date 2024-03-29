package lc46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        dfs(nums, new HashSet<>(), stack, res);

        return res;
    }

    private void dfs(int[] nums, Set<Integer> useIndexes, LinkedList<Integer> stack, List<List<Integer>> res) {
        if (useIndexes.size() == nums.length) {
            res.add(new ArrayList<>(stack));

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (useIndexes.contains(i)) {
                continue;
            }

            useIndexes.add(i);
            stack.addLast(nums[i]);

            dfs(nums, useIndexes, stack, res);

            useIndexes.remove(i);
            stack.removeLast();

        }
    }
}
