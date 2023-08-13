package lc518;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }

        if (coins.length == 0) {
            return 0;
        }

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();

        combinationSum(coins, amount, 0, stack, result);

        return result.size();
    }

    public void combinationSum(int[] coins, int amount, int i, LinkedList<Integer> stack, List<List<Integer>> result) {

        if (amount < 0) {
            return;
        }

        if (amount == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }


        for (int j = i; j < coins.length; j++) {
            stack.addLast(coins[j]);
            combinationSum(coins, amount - coins[j], j, stack, result);
            stack.removeLast();
        }
    }
}
