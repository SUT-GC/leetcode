package lc57;

public class Main {
    public static void main(String[] args) {
        int[][] intervals = new int[2][2];
        intervals[0][0] = 1;
        intervals[0][1] = 3;
        intervals[1][0] = 6;
        intervals[1][1] = 9;

        int[] newInterval = new int[2];
        newInterval[0] = 2;
        newInterval[1] = 5;

        // 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        int[][] intervals1 = new int[5][2];
        intervals1[0][0] = 1;
        intervals1[0][1] = 2;
        intervals1[1][0] = 3;
        intervals1[1][1] = 5;
        intervals1[2][0] = 6;
        intervals1[2][1] = 7;
        intervals1[3][0] = 8;
        intervals1[3][1] = 10;
        intervals1[4][0] = 12;
        intervals1[4][1] = 16;


        int[] newIntervals1 = new int[2];
        newIntervals1[0] = 4;
        newIntervals1[1] = 8;

        System.out.println(new Solution().insert(intervals1, newIntervals1));

    }
}
