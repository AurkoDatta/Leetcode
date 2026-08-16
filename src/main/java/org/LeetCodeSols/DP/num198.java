package org.LeetCodeSols.DP;

/***
 * cant rob two houses next to each other
 * keep track of two running totals as we go, the best if we skip this house and the best if we take it
 * at each house the new best is just max of those two, taking adds the current house to the skip total
 * roll the values forward instead of using a whole array
 */

public class num198 {
    public int rob(int[] nums) {
        int prev = 0;
        int curr = 0;

        for (int num : nums) {
            int temp = Math.max(curr, prev + num);
            prev = curr;
            curr = temp;
        }

        return curr;
    }
}
