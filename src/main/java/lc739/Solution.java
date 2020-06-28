package lc739;

import java.util.LinkedList;

public class Solution {

    public int[] dailyTemperatures(int[] T) {
        // corner case
        if (T == null || T.length <= 0) {
            return T;
        }

        int[] ans = new int[T.length];

        // stack
        LinkedList<Integer> stack = new LinkedList<>();

        // stack first
        stack.addLast(0);

        // loop
        for (int i = 1; i < T.length; i++) {
            if (!stack.isEmpty() && T[stack.getLast()] < T[i]) {
                while (!stack.isEmpty() && T[stack.getLast()] < T[i]) {
                    Integer node = stack.removeLast();
                    ans[node] = i - node;
                }
            }

            stack.addLast(i);
        }

        // last
        while (!stack.isEmpty()) {
            Integer node = stack.removeLast();
            ans[node] = 0;
        }

        return ans;
    }
}
