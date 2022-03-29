package lc172;

import java.util.stream.IntStream;

public class Solution {
    public int trailingZeroes(int n) {
        int numOf2 = 0;
        int numOf5 = 0;

        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (true) {
                if (temp % 2 == 0) {
                    numOf2++;
                    temp /= 2;
                } else if (temp % 5 == 0) {
                    numOf5++;
                    temp /= 5;
                } else {
                    break;
                }
            }
        }

        return Math.min(numOf2, numOf5);
    }
}
