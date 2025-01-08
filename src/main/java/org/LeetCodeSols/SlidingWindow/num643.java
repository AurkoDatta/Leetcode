package org.LeetCodeSols.SlidingWindow;

/***
 * Use a sliding window approach
 */

public class num643 {
    public static double findMaxAverage(int[] nums, int k) {
        // Initialize the sum of the first 'k' elements in the array
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Set the initial maximum sum to the sum of the first 'k' elements
        int maxSum = sum;

        // Iterate through the rest of the array, starting from the k-th element
        for (int i = k; i < nums.length; i++) {
            // Update the sum by adding the current element and subtracting the element
            // that is sliding out of the window (i.e., the element at index i - k)
            sum += nums[i] - nums[i - k];

            // Update the maximum sum if the current sum is greater
            maxSum = Math.max(maxSum, sum);
        }

        // Return the maximum average by dividing the maximum sum by 'k'
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums, 4));
    }
}
