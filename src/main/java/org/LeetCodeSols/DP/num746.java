package org.LeetCodeSols.DP;

/***
 * you can climb one or two steps at a time and pay the cost of the step you stand on
 * cost to reach a step is its own cost plus the cheaper of the two steps below it
 * roll two values forward instead of a whole array, the last two reachable steps
 * top is past the last index so start both at zero and the answer falls out at the end
 */

public class num746 {
    public int minCostClimbingStairs(int[] cost) {
        int prev = 0;
        int curr = 0;

        for (int i = 2; i <= cost.length; i++) {
            int step = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = step;
        }

        return curr;
    }
}
