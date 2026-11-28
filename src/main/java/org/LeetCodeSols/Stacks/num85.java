package org.LeetCodeSols.Stacks;

import java.util.Stack;

/***
 * the grid is reduced to a series of histogram problems, one per row, where heights tracks how many consecutive 1's are stacked directly above and including the current row for each column
 * walking through a row, heights[j] either grows by one when the cell is a '1', since the run of 1's above it keeps extending downward, or gets reset to 0 the moment a '0' breaks that run
 * after heights is updated for a row, largestRectangleArea is run on it, since the biggest rectangle with its bottom edge on this row is exactly the biggest rectangle that fits under this histogram
 * largestRectangleArea itself uses a stack of column indices kept in increasing order of height, so whatever index sits on top always points at the tallest bar seen so far that hasn't been closed off yet
 * an extra height of 0 is processed after the real bars so that anything still left on the stack at the end gets resolved as if the histogram dropped to the ground
 * whenever the incoming height is less than or equal to the bar on top of the stack, that bar can't extend any further to the right, so it gets popped and its rectangle is finalized using that height
 * the width of a popped bar's rectangle stretches from the bar now exposed underneath it on the stack, or all the way to the left edge if the stack is empty, out to the current position i
 * every popped rectangle's area is compared against maxArea, and the current index is pushed onto the stack once the while loop stops finding shorter bars to resolve
 * maxArea in maximalRectangle keeps the best area seen across every row's histogram, so by the time the last row is processed it holds the largest all-1's rectangle in the whole grid
 */

public class num85 {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (char[] row : matrix) {
            for (int j = 0; j < cols; j++) {
                heights[j] = row[j] == '1' ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {
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
