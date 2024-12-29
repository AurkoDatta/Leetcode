package org.LeetCodeSols.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * First, sort the arrays
 * Initialize a new array prev to the first array in the input
 * loop through the input array and sort accordingly using the prev array and another new array
 */

public class num56 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                result.add(prev);
                prev = interval;
            }
        }

        result.add(prev);

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] test = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(test));


    }
}
