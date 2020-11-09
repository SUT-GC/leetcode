package lc122;


class Solution {

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }

        // [][0] 手里没有任何股票
        // [][1] 手里有支股票
        int[][] profit = new int[prices.length][2];

        profit[0][0] = 0;
        profit[0][1] = -prices[0];

        for (int i = 1; i < profit.length; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
            profit[i][1] = Math.max(profit[i - 1][0] - prices[i], profit[i - 1][1]);
        }

        return profit[prices.length - 1][0];
    }
}