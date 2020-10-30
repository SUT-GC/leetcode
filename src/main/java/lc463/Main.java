package lc463;

public class Main {
    public static void main(String[] args) {
        int[][] map = new int[4][4];
        map[0] = new int[]{0, 1, 0, 0};
        map[1] = new int[]{1, 1, 1, 0};
        map[2] = new int[]{0, 1, 0, 0};
        map[3] = new int[]{1, 1, 0, 0};

        System.out.println(new Solution().islandPerimeter(map));
    }
}
