package lc322;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void dfs(int[] coins, int index, int amount, int cnt) {
        if (index < 0) {
            return;
        }
        for (int c = amount / coins[index]; c >= 0; c--) {
            int na = amount - c * coins[index];
            int ncnt = cnt + c;
            if (na == 0) {
                ans = Math.min(ans, ncnt);
                break;//剪枝1
            }
            if (ncnt + 1 >= ans) {
                break; //剪枝2
            }
            dfs(coins, index - 1, na, ncnt);
        }
    }
}
