package org.LeetCodeSols.BinarySearch;

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
