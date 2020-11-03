package lc941;

public class Solution {
    public boolean validMountainArray(int[] A) {
        if (null == A || A.length < 3) {
            return false;
        }


        int maxI = 0;
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                maxI = i;
                max = A[i];
            }
        }

        if (maxI == 0 || maxI == A.length - 1) {
            return false;
        }

        for (int i = 1; i <= maxI; i++) {
            if (A[i] <= A[i - 1]) {
                return false;
            }
        }

        for (int i = maxI + 1; i < A.length; i++) {
            if (A[i] >= A[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
