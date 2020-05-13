package lc69;

public class Solution {
    public int mySqrt(int x) {
        int start = 0;
        int end = x;

        while (end - start > 1) {
            int mid = (start + end) / 2;
            if (Math.pow(mid, 2) < (long) x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return (long) end * end <= (long) x ? end : end - 1;
    }
}
