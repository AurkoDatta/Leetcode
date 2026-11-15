package org.LeetCodeSols.Arrays;

/***
 * h-index is the largest h such that at least h papers have h or more citations each, so the search is really over the range of possible h values from n down to 0
 * count has n + 1 slots, and every citation gets bucketed into count[Math.min(c, n)], since once a paper's citations reach n it can't push h any higher than n anyway
 * walking count from index n down to 0, total keeps a running sum of count[i] through count[n], which is exactly how many papers have at least i citations
 * the first index i where total is at least i means i papers already have i or more citations each, satisfying the h-index definition, and starting from n and moving down guarantees that's the largest such i
 * returning 0 after the loop covers citations being empty, since no papers at all trivially satisfies h = 0
 */

public class num274 {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];

        for (int c : citations) {
            count[Math.min(c, n)]++;
        }

        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }

        return 0;
    }
}
