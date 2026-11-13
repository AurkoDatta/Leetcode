package org.LeetCodeSols.Arrays;

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
