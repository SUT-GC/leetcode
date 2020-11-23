package lc452;

public class Main {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {10, 6},
                {2, 8},
                {1, 6},
                {7, 12}
        };

        Solution solution = new Solution();

        System.out.println(solution.findMinArrowShots(input));
    }
}
