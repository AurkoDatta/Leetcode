package org.LeetCodeSols.BinarySearch;

/***
 * start at the top right corner of the matrix, since that cell is the biggest value in its row and the smallest value in its column
 * whenever the current cell matches target the search is already done
 * if the current cell is bigger than target, everything below it in that column is even bigger, so the whole column can be ruled out by stepping left
 * if the current cell is smaller than target, everything to the left in that row is even smaller, so the whole row can be ruled out by stepping down
 * each step eliminates either a full row or a full column, so row and col are guaranteed to walk off the matrix if target was never going to be found
 */

public class num240 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
