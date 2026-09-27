package org.LeetCodeSols.Arrays;

/***
 * jumps counts how many jumps have been taken so far, currentEnd marks the farthest index reachable using that many jumps
 * farthest tracks the best possible reach found from any index visited while still inside the current jump's range
 * walking through the array, farthest keeps getting updated to i plus however far that index alone can jump
 * once i reaches currentEnd, every option inside the current jump's range has been explored, so a new jump gets taken and currentEnd advances to farthest
 * by the time the loop reaches the second to last index, jumps holds the fewest jumps needed to reach the last index
 */

public class num45 {
    public static int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
