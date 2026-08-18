package org.LeetCodeSols.SlidingWindow;

/***
 * keep a count array for every letter currently in the window
 * track the highest single letter count seen so far in the window
 * if window size minus that highest count is bigger than k we would need too many swaps so shrink from the left
 * answer is just the biggest window size we ever hit
 */

public class num424 {
    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        System.out.println(characterReplacement(s, 1));
    }
}
