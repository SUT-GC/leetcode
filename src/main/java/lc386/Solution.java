package lc386;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            if (i <= n) {
                ans.add(i);
                ans.addAll(dfs(10 * i, n));
            }
        }

        return ans;
    }

    public List<Integer> dfs(int num, int max) {
        if (num > max) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= 9; i++) {
            if (num + i <= max) {
                result.add(num + i);
                result.addAll(dfs(10 * (num + i), max));
            }
        }

        return result;
    }
}
