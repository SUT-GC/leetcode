package lc983;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] days = {1, 4, 6, 7, 8, 365};
        int[] costs = {2, 7, 15};
        System.out.println(solution.mincostTickets(days, costs));
    }
}
