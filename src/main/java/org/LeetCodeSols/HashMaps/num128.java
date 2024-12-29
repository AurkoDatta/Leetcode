package org.LeetCodeSols.HashMaps;

import java.util.HashSet;
import java.util.Set;

/***
 * Loop thorugh each value in the array and add it to the set
 * Set a new variable longest to 0
 * Loop through the input array again, if the set doesn't contain the current iteration then,
 * while the numSet contains num + length, increment length
 * At the end of each iteration, set longest to the maximum of longest and length
 */

public class num128 {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int length = 1;

                while (numSet.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;

    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};

        System.out.println(longestConsecutive(nums));
    }
}
