package org.LeetCodeSols.Arrays;

import java.util.ArrayList;
import java.util.List;

/***
 * the intervals come in already sorted by start time, so the new interval only needs to be merged into the right spot once
 * the first loop copies over every interval that ends before the new one even starts, those are untouched since nothing overlaps them yet
 * the second loop walks through every interval that overlaps the new one, stretching the new interval's bounds to swallow each one it touches
 * once that loop stops, newInterval has grown to cover its entire overlapping range and gets added to the result as a single merged interval
 * the last loop just copies over whatever intervals are left, they all start after the merged interval ends so none of them need touching
 */

public class num57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
