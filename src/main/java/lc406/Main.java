package lc406;

public class Main {
    public static void main(String[] args) {
        //[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        int[][] input = new int[6][2];
        input[0][0] = 7;
        input[0][1] = 0;
        input[1][0] = 4;
        input[1][1] = 4;
        input[2][0] = 7;
        input[2][1] = 1;
        input[3][0] = 5;
        input[3][1] = 0;
        input[4][0] = 6;
        input[4][1] = 1;
        input[5][0] = 5;
        input[5][1] = 2;

        System.out.println(new Solution().reconstructQueue(input));
    }
}
