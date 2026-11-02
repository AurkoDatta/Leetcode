package org.LeetCodeSols.Arrays;

/***
 * reversing the whole array flips every element end to end, which gets close to a right rotation by k but leaves the two pieces that should stay in order internally reversed as well
 * reversing just the first k elements undoes that for the piece now sitting at the front, putting what used to be the last k elements of the array back in their original order
 * reversing the remaining n - k elements does the same for the piece left behind, restoring the original order of what used to be the first n - k elements, now sitting at the end where they belong
 * taking k mod n first handles any k that's bigger than the array, since rotating by a full length of n just brings the array back to where it started
 */

public class num189 {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
