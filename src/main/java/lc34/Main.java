package lc34;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = solution.searchRange(new int[]{0, 1, 2}, 1);

        System.out.println(Arrays.toString(ans));
    }
}
