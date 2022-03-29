package lc2028;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int mSum = Arrays.stream(rolls).sum();
        int nSum = (n + rolls.length) * mean - mSum;

        int nIntAvg = nSum / n;
        int nIntRem = nSum % n;

        if (nIntAvg > 6 || nIntAvg <= 0 || (nIntAvg == 6 && nIntRem > 0)) {
            return new int[]{};
        } else {
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = nIntAvg;
            }

            for (int i = 0; i < n && nIntRem > 0; i++, nIntRem--) {
                result[i] += 1;
            }

            return result;
        }
    }
}