package org.LeetCodeSols.SlidingWindow;

/***
 * keep adding numbers to a running sum as the right side grows
 * once the sum is at least the target start shrinking from the left
 * every time we shrink record the window size if its the smallest so far
 * if we never hit the target return 0
 */

public class num209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }
}
