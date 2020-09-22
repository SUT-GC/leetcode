package lc216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        traceBack(k, n, 0, 1, new LinkedList<>());

        return ans;
    }

    public void traceBack(int k, int n, int sum, int begin, LinkedList<Integer> stack) {
        if (k == 0 && n == sum) {
            ans.add(new ArrayList<>(stack));
            return;
        }

        if (k == 0 && n != sum) {
            return;
        }

        for (int i = begin; i <= 9; i++) {
            stack.addLast(i);
            traceBack(k - 1, n, sum + i, i + 1, stack);
            stack.removeLast();
        }
    }
}
