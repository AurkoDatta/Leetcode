package org.LeetCodeSols.Set1;

public class num48 {
    public static void rotate(int[][] matrix) {

        //Tranpose
        int n = matrix.length;
        for (int i = 0; i < n ; i++) {
            for (int j = i+1; j < n ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2 ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 -j];
                matrix[i][n - 1 -j] = temp;
            }
        }

    }
}
