package lc693;

class Solution {
    public boolean hasAlternatingBits(int n) {
        while (n > 0) {
            int a = n % 2;
            n = n / 2;
            int b = n % 2;

            if (a != b) {
                continue;
            }

            return false;
        }

        return true;
    }
}