package org.LeetCodeSols.Set1;

import java.util.ArrayList;
import java.util.List;

public class num54 {
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        int vertLength = matrix.length;
        int horizLength = matrix[0].length;

        int startRow = 0;
        int startCol = 0;
        int endRow = vertLength - 1;
        int endCol = horizLength - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Traverse from left to right
            for (int j = startCol; j <= endCol; j++) {
                res.add(matrix[startRow][j]);
            }
            startRow++;

            // Traverse from top to bottom
            for (int i = startRow; i <= endRow; i++) {
                res.add(matrix[i][endCol]);
            }
            endCol--;

            // Traverse from right to left
            if (startRow <= endRow) {
                for (int j = endCol; j >= startCol; j--) {
                    res.add(matrix[endRow][j]);
                }
                endRow--;
            }

            // Traverse from bottom to top
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    res.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }
}
