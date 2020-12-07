package lc861;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[][]{
                new int[]{0, 0, 1, 1},
                new int[]{1, 0, 1, 0},
                new int[]{1, 1, 0, 0}
        };

        int ans = solution.matrixScore(input);
        System.out.println(ans);
    }
}
