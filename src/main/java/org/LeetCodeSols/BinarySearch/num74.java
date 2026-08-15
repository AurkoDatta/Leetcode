package org.LeetCodeSols.BinarySearch;

/***
 * treat the whole 2d matrix like one flattened sorted array
 * do a normal binary search over indices 0 to rows*cols - 1
 * convert the mid index back into a row and col using division and mod
 * compare that value to target and shrink the range like a regular binary search
 */

public class num74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / cols][mid % cols];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
