package org.LeetCodeSols.SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * slide a window of size k across nums, keeping a deque of indices instead of values
 * front of the deque always holds the index of the current window's max
 * before pushing a new index, pop off any weaker values from the back since they can never
 * win the max while the new one is still in the window
 * drop the front index once it slides outside the window, then record it once the window is full
 */

public class num239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
