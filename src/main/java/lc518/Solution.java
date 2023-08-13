package lc518;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // [1,2,5,10]
    // -> 11
    public int change(int amount, int[] coins) {
        // 初始化所有场景为0
        int[] dp = new int[amount + 1];

        // 初始化状态，0 = 1
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

}
