package org.LeetCodeSols.Stacks;

import java.util.Stack;

public class num907 {
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1_000_000_007;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> leftStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!leftStack.isEmpty() && arr[leftStack.peek()] > arr[i]) {
                leftStack.pop();
            }
            left[i] = leftStack.isEmpty() ? i + 1 : i - leftStack.peek();
            leftStack.push(i);
        }

        Stack<Integer> rightStack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!rightStack.isEmpty() && arr[rightStack.peek()] >= arr[i]) {
                rightStack.pop();
            }
            right[i] = rightStack.isEmpty() ? n - i : rightStack.peek() - i;
            rightStack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + (long) arr[i] * left[i] * right[i]) % mod;
        }

        return (int) sum;
    }
}
