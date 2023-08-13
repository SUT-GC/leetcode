package lc40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        Set<Integer> used = new HashSet<>();

        dfs(candidates, target, 0, stack, result);

        return result;
    }

    private void dfs(int[] candidates, int target, int start, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 同一层节点，如果上一个dfs的跟这次一样，就不处理了
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            stack.addLast(candidates[i]);

            dfs(candidates, target - candidates[i], i + 1, stack, result);

            stack.removeLast();

        }

    }
}
