package org.LeetCodeSols.DP;

/***
 * buy1 tracks the best profit achievable after making just the first purchase, stored as a negative number since paying for a share is a loss until it's sold, and it only ever improves by finding a cheaper price to buy at
 * sell1 tracks the best profit after completing one full buy-sell pair, which comes from either keeping the previous best or selling off buy1's share at the current price
 * buy2 builds on top of sell1 rather than starting from zero, since any profit already locked in from the first sale can be reinvested into a second share, so buy2 is the best profit after using that money to buy again
 * sell2 mirrors sell1 but on top of buy2, so it's the best profit after both pairs of transactions are complete, using the current price to close out the second share
 * all four variables get updated on every price in the same pass, and because buy2 and sell2 both depend on values computed earlier in the same iteration, the two transactions naturally stay in the correct order without needing to track dates directly
 * sell2 at the end holds the max profit from at most two non-overlapping transactions, with it defaulting to 0 since doing nothing at all is always a valid option
 */

public class num123 {
    public static int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, sell1 = 0;
        int buy2 = Integer.MIN_VALUE, sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }
}
