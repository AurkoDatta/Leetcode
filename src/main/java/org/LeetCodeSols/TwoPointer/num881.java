package org.LeetCodeSols.TwoPointer;

import java.util.Arrays;

/***
 * sorting people first by weight means the lightest and heaviest people still waiting are always sitting at the two ends of the array, which is exactly what left and right end up tracking
 * right always points at the heaviest person left to seat, since that person is the hardest one to pair up and has to go out on a boat either way
 * when the lightest person still waiting, people[left], can share a boat with that heaviest person without going over limit, the two of them go out together and left moves inward since that lightest person is now taken care of
 * when the two of them together would go over limit, the heaviest person just goes out alone instead, and left stays put so that same lightest person gets another shot at pairing up with whoever's heaviest next
 * right moves inward either way, since whichever boat just got built, whether it carried one person or two, used up the heaviest person still remaining, and boats goes up by one for every boat that gets built that way
 * the loop keeps building boats until left and right cross, which is the point where everyone still waiting has already been seated on one
 */

public class num881 {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }

        return boats;
    }
}
