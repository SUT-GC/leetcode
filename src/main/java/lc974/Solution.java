package lc974;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> dict = new HashMap<>(A.length);
        dict.put(0, 1);

        int sum = 0;
        int ans = 0;
        for (int a : A) {
            sum += a;
            int mode = (sum % K + K) % K;
            ans += dict.getOrDefault(mode, 0);
            dict.compute(mode, (k, v) -> v == null ? 1 : v + 1);
        }

        return ans;
    }
}
