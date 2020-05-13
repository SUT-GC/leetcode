package lc322;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = new int[]{186, 419, 83, 408};
        int amount = 6249;
//        int[] coins = new int[]{1, 7, 10};
//        int amount = 14;
        System.out.println(solution.coinChange(coins, amount));
    }
}
