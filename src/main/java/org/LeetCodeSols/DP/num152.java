package org.LeetCodeSols.DP;

/***
 * a negative number can flip the smallest running product into the largest one, so both the max and min ending at each index need to be tracked
 * maxSoFar and minSoFar hold the best and worst product of a subarray that ends exactly at the previous index
 * at each new number, the candidates for the new max and min are the number alone, or the number times whichever of maxSoFar or minSoFar it pairs with
 * multiplying by a negative number swaps which of those candidates is bigger, which is why both max and min get recomputed from the same three candidates every step
 * result keeps track of the best maxSoFar seen across every index, which ends up being the answer
 */

public class num152 {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));
            maxSoFar = tempMax;

            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}
