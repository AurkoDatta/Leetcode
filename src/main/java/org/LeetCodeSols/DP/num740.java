package org.LeetCodeSols.DP;

/***
 * deleting every copy of some number also wipes out every copy of number-1 and number+1, so this collapses into choosing which numbers to keep across the whole range, the same shape as house robber
 * points[i] rolls up how much taking every occurrence of i is worth in one go, since taking a single copy of i means taking them all anyway
 * take and skip carry the best score reachable up to i depending on whether i itself got taken, mirroring the two running totals from house robber
 * newTake can only build off skip, since taking i means i-1 had to be left alone, while newSkip just carries forward whichever of take or skip was better at i-1
 * walking i from 0 up to maxNum pushes take and skip forward one number at a time, so by the end they hold the best totals whether or not maxNum itself got taken
 * the bigger of take and skip once the loop finishes is the most points obtainable overall
 */

public class num740 {
    public static int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        int[] points = new int[maxNum + 1];
        for (int num : nums) {
            points[num] += num;
        }

        int take = 0;
        int skip = 0;

        for (int i = 0; i <= maxNum; i++) {
            int newTake = skip + points[i];
            int newSkip = Math.max(take, skip);
            take = newTake;
            skip = newSkip;
        }

        return Math.max(take, skip);
    }
}
