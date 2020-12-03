package lc204;


public class Solution {
    public int countPrimes(int n) {

        if (n == 0 || n == 1) {
            return 0;
        }

        int[] map = new int[n];

        map[0] = 1;
        map[1] = 1;
        for (int i = 2; i < map.length; i++) {
            if (map[i] == 0) {
                for (int j = 2 * i; j < map.length; j += i) {
                    map[j] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (map[i] == 0) {
                count++;
            }
        }

        return count;
    }
}
