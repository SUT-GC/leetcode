package lc983;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        dp[0] = 0;

        Set<Integer> goDays = Arrays.stream(days).boxed().collect(Collectors.toSet());
        IntStream.range(1, 366).forEach(i -> {
            if (goDays.contains(i)) {
                dp[i] = Math.min(Math.min(dp[i - 1] + costs[0], i >= 7 ? dp[i - 7] + costs[1] : costs[1]), i >= 30 ? dp[i - 30] + costs[2] : costs[2]);
            } else {
                dp[i] = dp[i - 1];
            }
        });

        return dp[days[days.length - 1]];
    }
}
