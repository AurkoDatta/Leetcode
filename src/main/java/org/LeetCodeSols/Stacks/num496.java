package org.LeetCodeSols.Stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/***
 * nums2 holds every number that could ever be asked about, so the next greater value for each of them only needs to be worked out once by scanning it a single time
 * the stack holds numbers that are still waiting on something bigger to show up later in nums2, kept in increasing order from bottom to top
 * when the current num is bigger than what's on top of the stack, that top value just found its answer, so it gets popped and mapped to num, and this keeps happening for every smaller value still sitting on top
 * once nothing left on the stack is smaller than num, num itself goes on top to wait for its own next greater value
 * any number still on the stack after the whole scan never found something bigger after it, so it's left out of the map entirely
 * for nums1, looking each value up in the map gives its answer directly, and getOrDefault handles the case where it was never mapped by returning -1 instead
 */

public class num496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
