package lc18;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> r = new Solution().fourSum(new int[]{-4, -3, -2, -1, 0, 0, 1, 2, 3, 4}, 0);
        System.out.println(r);
    }
}
