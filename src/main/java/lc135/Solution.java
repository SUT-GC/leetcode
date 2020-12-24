package lc135;

public class Solution {
    public int candy(int[] ratings) {
        if (null == ratings) {
            return 0;
        }

        int[] left = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int[] right = new int[ratings.length];
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i + 1] < ratings[i]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < ratings.length; i++) {
            ans += Math.max(left[i], right[i]);
        }

        return ans;
    }
}
