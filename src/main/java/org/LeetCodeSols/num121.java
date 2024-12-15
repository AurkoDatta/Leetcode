package org.LeetCodeSols;

import java.lang.reflect.Array;
import java.util.Arrays;

public class num121 {
    public static int maxProfit(int[] prices) {
        int result = 0;
        int temp1 = Arrays.stream(prices).min().getAsInt();

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] == temp1){
                for (int j = i; j < prices.length; j++) {
                    int profit = prices[j] - temp1;
                    result = Math.max(result, profit);

                }
                break;
            }
        }


        return result;
    }


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2}));
    }
}
