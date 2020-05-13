package lc221;

public class Main {
    public static void main(String[] args) {
        /**
         * 1 0 1 0 0
         * 1 0 1 1 1
         * 1 1 1 1 1
         * 1 0 0 1 0
         */

        char[][] matrix = new char[4][5];
        matrix[0] = new char[]{'1', '0', '1', '0', '1'};
        matrix[1] = new char[]{'1', '0', '1', '1', '1'};
        matrix[2] = new char[]{'1', '1', '1', '1', '1'};
        matrix[3] = new char[]{'1', '0', '0', '1', '0'};

        Solution solution = new Solution();
        System.out.println(solution.maximalSquare(matrix));
    }
}
