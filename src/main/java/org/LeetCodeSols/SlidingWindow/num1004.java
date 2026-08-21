package org.LeetCodeSols.SlidingWindow;

/***
 * grow the window from the right, counting zeros as they come in
 * once zeroCount goes over k start shrinking from the left until its back at k
 * shrinking only drops the count when the left value itself is a zero
 * max window size seen along the way is the answer
 */

public class num1004 {
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLength = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);


        }

        return maxLength;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums, 2));
    }

}
