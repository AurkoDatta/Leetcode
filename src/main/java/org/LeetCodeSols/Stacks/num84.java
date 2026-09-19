package org.LeetCodeSols.Stacks;

import java.util.Stack;

/***
 * walk through heights with one extra step past the end where h is treated as 0, so the stack always empties out
 * keep a stack of indices whose bars are in increasing height order
 * when the current bar is shorter than the bar at the top of the stack, that top bar can't stretch any further right
 * pop it off and use its height times the gap between the new stack top and the current index as a candidate area
 * keep popping and comparing areas until the stack only holds bars shorter than or equal to the current one, then push the current index
 * maxArea ends up holding the biggest rectangle found this way
 */

public class num84 {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= h) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
