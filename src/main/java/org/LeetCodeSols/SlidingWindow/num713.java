package org.LeetCodeSols.SlidingWindow;

/***
 * product tracks the running product of whatever window [left, right] currently holds, growing every time right moves forward by multiplying in nums[right]
 * once product reaches or passes k the window stops being valid, so left keeps moving forward dividing nums[left] back out until product drops under k again
 * every value in nums is at least 1, so the product only grows as right extends the window and only shrinks as left catches up, never the other way around
 * once the window ending at right is valid, every subarray ending at right that starts anywhere from left up to right also has a product under k, since dropping more values off the front can only shrink the product further, so right - left + 1 of them get counted at once
 * k <= 1 is handled upfront since no subarray's product, always at least 1, can ever land below it
 */

public class num713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int left = 0;
        long product = 1;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
