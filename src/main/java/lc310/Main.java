package lc310;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> minHeightTrees = new Solution().findMinHeightTrees(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}});

        System.out.println(minHeightTrees);
    }
}
