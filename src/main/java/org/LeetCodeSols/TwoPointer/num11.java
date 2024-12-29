package org.LeetCodeSols.TwoPointer;

/***
 * Use a two pointer approach
 * Calculate the current area using the formula
 * Set the result to the max of result or the current area
 */

public class num11 {
    public int maxArea(int[] height) {
        int res = 0;

        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] < height[right]) {
                //If left height is smaller, increment left pointer
                left++;
            } else {
                //If right height is smaller or equal, increment right pointer
                right--;
            }
        }

        return res;
    }
}
