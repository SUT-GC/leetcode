package lc357;

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }

        int result = 10;
        int current = 9;
        for (int i = 0; i < n - 1; i++) {
            current *= (9 - i);
            result += current;
        }

        return result;
    }
}
