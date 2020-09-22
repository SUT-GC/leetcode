package lc79;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] a = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(solution.exist(a, "ABCEFSADEESE"));
    }
}
