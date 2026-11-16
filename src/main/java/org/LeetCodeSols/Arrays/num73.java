package org.LeetCodeSols.Arrays;

/***
 * instead of allocating a separate structure to remember which rows and columns contain a zero, the first row and first column of the matrix itself get reused as the markers
 * before anything is overwritten, firstRowZero and firstColZero capture whether row 0 or column 0 originally held a zero, since those two cells are about to start getting used for something else
 * walking the rest of the matrix starting from row 1 and column 1, whenever a zero turns up its row's marker in column 0 and its column's marker in row 0 both get set to zero
 * a second pass over that same inner region zeroes out any cell whose row marker or column marker is zero, since that's exactly what those markers were tracking
 * only after that second pass finishes can row 0 and column 0 themselves get wiped out, using the firstRowZero and firstColZero flags saved at the start, otherwise those marker cells would have been zeroed out before the inner region finished reading them
 */

public class num73 {
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int r = 0; r < rows; r++) {
            if (matrix[r][0] == 0) firstColZero = true;
        }
        for (int c = 0; c < cols; c++) {
            if (matrix[0][c] == 0) firstRowZero = true;
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int c = 0; c < cols; c++) {
                matrix[0][c] = 0;
            }
        }
        if (firstColZero) {
            for (int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}
