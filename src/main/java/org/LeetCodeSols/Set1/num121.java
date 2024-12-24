package org.LeetCodeSols.Set1;

import java.util.Arrays;

/***
 * set minPrice to a very large integer
 * use a base case
 * loop through the input array
 * set minPrice as the minimum between minPrice and the current iteration of the loop
 * calculate profit
 * final result is max between result and profit
 */

public class num121 {
    public static int maxProfit(int[] prices) {
        int result = 0;
        int minPrice = Integer.MAX_VALUE;

        if (prices == null || prices.length == 1) return result;

        for (int i : prices){
            minPrice = Math.min(minPrice, i);

            int profit = i - minPrice;

            result = Math.max(result, profit);

        }


        return result;
    }


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2, 4, 1}));
    }
}
