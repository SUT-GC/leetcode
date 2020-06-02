package lcms64;

public class Solution {
    public int[] a = new int[]{0};

    public int sumNums2(int n) {
        try {
            return a[n];
        } catch (Exception e) {
            return n + sumNums(n - 1);
        }
    }

    public int sumNums(int n) {
        return ((int) Math.pow(n, 2) + n) >> 1;
    }
}
