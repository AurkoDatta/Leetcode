package org.LeetCodeSols.Arrays;

import java.util.ArrayList;
import java.util.List;

/***
 * triangle builds up one row at a time, with each new row's length just being one more than the row before it, matching how row i of Pascal's triangle has i + 1 entries
 * within a row, the first and last entry are always 1, since those are the edges of the triangle and have nothing above them to combine
 * every entry in between is the sum of the two entries sitting above it in the previous row, the one directly above and the one above and to the left
 * j tracks the position being filled in the current row, so triangle.get(i - 1).get(j - 1) and triangle.get(i - 1).get(j) are exactly those two parents from the row before
 * once a row is fully built it gets added onto triangle, which is what later rows read from to build themselves, and triangle itself is what gets returned once numRows rows have been generated
 */

public class num118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }

            triangle.add(row);
        }

        return triangle;
    }
}
