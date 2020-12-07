package lc861;

import java.util.Arrays;

public class Solution {
    public int matrixScore(int[][] A) {
        if (null == A || A.length == 0) {
            return 0;
        }

        // 将左边第一列全部设置为1
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                continue;
            }

            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }


        // 将除第一列之外所有列中，0 比 1 多的列反转
        for (int j = 1; j < A[0].length; j++) {
            int oneCount = 0;
            int zeroCount = 0;

            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == 1) {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }

            if (zeroCount > oneCount) {
                for (int i = 0; i < A.length; i++) {
                    if (A[i][j] == 1) {
                        A[i][j] = 0;
                    } else {
                        A[i][j] = 1;
                    }
                }
            }
        }


        System.out.println(Arrays.toString(A));

        // 计算二进制和
        int ans = 0;
        for (int[] ints : A) {
            StringBuilder bNum = new StringBuilder();
            for (int j = 0; j < ints.length; j++) {
                bNum.append(ints[j]);
            }
            ans += Integer.valueOf(bNum.toString(), 2);
        }

        return ans;
    }
}

