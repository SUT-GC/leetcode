package lc134;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};

        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}
