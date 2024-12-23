package org.LeetCodeSols.Set1;

import java.util.Arrays;

public class num121 {
    public static int maxProfit(int[] prices) {
        int result = 0;
        int minPrice = Integer.MAX_VALUE;

        if (prices == null || prices.length == 1) return result;
        int temp1 = Arrays.stream(prices).min().getAsInt();

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
