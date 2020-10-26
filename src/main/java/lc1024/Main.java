package lc1024;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input1 = new int[][]{
                new int[]{0, 2},
                new int[]{4, 6},
                new int[]{8, 10},
                new int[]{1, 9},
                new int[]{1, 5},
                new int[]{5, 9}
        };
        int inputT1 = 10;

        // [0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]  T = 9
        int[][] input2 = new int[][]{
                new int[]{0, 1},
                new int[]{6, 8},
                new int[]{0, 2},
                new int[]{5, 6},
                new int[]{0, 4},
                new int[]{0, 3},
                new int[]{6, 7},
                new int[]{1, 3},
                new int[]{4, 7},
                new int[]{1, 4},
                new int[]{2, 5},
                new int[]{2, 6},
                new int[]{3, 4},
                new int[]{4, 5},
                new int[]{5, 7},
                new int[]{6, 9}
        };
        int inputT2 = 9;

        // clips = [[0,4],[2,8]], T = 5
        int[][] input3 = new int[][]{
                new int[]{0, 4},
                new int[]{2, 8},
        };
        int inputT3 = 5;

        // clips = [[0,1],[1,2]], T = 5
        int[][] input4 = new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
        };
        int inputT4 = 5;

        System.out.println(solution.videoStitching(input2, inputT2));

    }
}
