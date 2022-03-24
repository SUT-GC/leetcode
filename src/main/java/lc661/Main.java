package lc661;

public class Main {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {100, 200, 100},
                {200, 50, 200},
                {100, 200, 100}
        };

        System.out.println(new Solution().imageSmoother(a));
    }
}
