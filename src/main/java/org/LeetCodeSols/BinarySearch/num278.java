package org.LeetCodeSols.BinarySearch;

public class num278 {
    private final int bad;

    public num278(int bad) {
        this.bad = bad;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isBadVersion(int version) {
        return version >= bad;
    }
}
