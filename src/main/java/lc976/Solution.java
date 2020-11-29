package lc976;

import java.util.Arrays;

public class Solution {
    public int largestPerimeter(int[] A) {
        if (null == A || A.length < 3) {
            return 0;
        }

        Arrays.sort(A);

        for (int i = A.length - 1; i >= 2; i--) {
            if ((A[i - 2] + A[i - 1]) > A[i]) {
                return A[i - 1] + A[i - 2] + A[i];
            }
        }

        return 0;
    }
}
