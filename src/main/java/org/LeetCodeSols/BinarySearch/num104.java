package org.LeetCodeSols.BinarySearch;

/***
 * standard binary search, array is already sorted so no tricks needed
 * left and right pointers, check the middle each pass
 * mid too small push left up, mid too big pull right down
 * either equal case returns mid right away, -1 if the loop runs out
 */

public class num104 {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;

            }
            else if (nums[mid] > target) {
                right = mid - 1;

            }
            else {
                return mid;

            }
        }


        return -1;

    }

    public static void main(String[] args) {

    }
}
