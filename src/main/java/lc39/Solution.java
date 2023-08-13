package lc39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        dfs(candidates, target, 0, result, stack);

        return result;
    }

    private void dfs(int[] candidates, int target, int i, List<List<Integer>> result, LinkedList<Integer> stack) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }


        for (int j = i; j < candidates.length; j++) {
            stack.addLast(candidates[j]);
            dfs(candidates, target - candidates[j], j, result, stack);
            stack.removeLast();
        }
    }
}
