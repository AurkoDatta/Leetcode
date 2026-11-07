package org.LeetCodeSols.DP;

public class num673 {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];
        int maxLength = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            length[i] = 1;
            count[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }

            if (length[i] > maxLength) {
                maxLength = length[i];
                result = count[i];
            } else if (length[i] == maxLength) {
                result += count[i];
            }
        }

        return result;
    }
}
