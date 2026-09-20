package org.LeetCodeSols.Arrays;

/***
 * greedily grab every uptick since any zigzag path through the prices can be broken into a string of smaller up moves that add up to the same total
 * walk through prices comparing each day to the one right before it
 * whenever the price went up from the previous day, add that difference straight to profit as if bought the day before and sold today
 * a drop or flat day contributes nothing so it's skipped
 * profit ends up equal to the sum of every single day gain across the whole array
 */

public class num122 {
    public static int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
