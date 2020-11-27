package lc454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int AB = a + b;
                countAB.compute(AB, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        int ans = 0;
        for (int c : C) {
            for (int d : D) {
                int CD = c + d;
                ans += countAB.getOrDefault(-CD, 0);
            }
        }

        return ans;
    }
}
