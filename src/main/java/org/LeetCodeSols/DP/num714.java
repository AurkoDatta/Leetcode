package org.LeetCodeSols.DP;

public class num714 {
    public static int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }
}
