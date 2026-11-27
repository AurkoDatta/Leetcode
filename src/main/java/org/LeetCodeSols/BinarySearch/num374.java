package org.LeetCodeSols.BinarySearch;

public class num374 {
    private final int target;

    public num374(int target) {
        this.target = target;
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private int guess(int num) {
        if (num == target) {
            return 0;
        }
        return num > target ? -1 : 1;
    }
}
