package org.LeetCodeSols.Arrays;

/***
 * totalTank tracks whether the trip is possible at all, adding up gas minus cost across every station on the route
 * currTank tracks the fuel building up starting from whatever station is currently the candidate starting point
 * diff at each station is how much gas is gained or lost by visiting it
 * once currTank drops below zero none of the stations from the current start up through i could have worked either, so the next station becomes the new candidate start and currTank resets to zero
 * if totalTank never dips below zero across the whole trip a valid starting station exists and start holds it, otherwise the circuit can't be completed no matter where you begin
 */

public class num134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalTank += diff;
            currTank += diff;

            if (currTank < 0) {
                start = i + 1;
                currTank = 0;
            }
        }

        return totalTank >= 0 ? start : -1;
    }
}
