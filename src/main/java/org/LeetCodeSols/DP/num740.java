package org.LeetCodeSols.DP;

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
