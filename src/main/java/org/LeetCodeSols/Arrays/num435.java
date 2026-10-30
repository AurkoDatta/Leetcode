package org.LeetCodeSols.Arrays;

import java.util.Arrays;

/***
 * sorting by end time first means the interval that finishes earliest is always considered before any interval that overlaps it
 * prevEnd tracks the end of whichever interval was last kept, starting as the end of the very first interval since nothing before it could conflict
 * walking through the rest, an interval whose start is before prevEnd overlaps the one just kept, so it has to be the one erased and count goes up
 * an interval whose start lands at or after prevEnd doesn't overlap, so it gets kept instead and prevEnd advances to its end
 * always keeping the interval that ends soonest leaves the most room for everything coming after it, which is why sorting by end time guarantees the fewest removals
 * count ends up holding exactly how many intervals had to be erased to make the rest non-overlapping
 */

public class num435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                count++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}
