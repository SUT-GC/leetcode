package lc832;

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        A = flip(A);
        A = reversal(A);

        return A;
    }

    private int[][] reversal(int[][] a) {
        if (null == a || a.length <= 0) {
            return a;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = a[i][j] == 1 ? 0 : 1;
            }
        }

        return a;
    }

    private int[][] flip(int[][] a) {
        if (null == a || a.length <= 0) {
            return a;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0, z = a[i].length - 1; j <= z; j++, z--) {
                swap(a, i, j, i, z);
            }
        }

        return a;
    }

    private void swap(int[][] a, int i, int j, int y, int z) {
        int temp = a[i][j];
        a[i][j] = a[y][z];
        a[y][z] = temp;
    }
}