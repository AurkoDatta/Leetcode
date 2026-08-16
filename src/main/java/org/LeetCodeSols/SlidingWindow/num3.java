package org.LeetCodeSols.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/***
 * grow the window from the right adding chars to a set
 * if the char is already in the set shrink from the left until its gone
 * track the max window size along the way
 */

public class num3 {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (window.contains(c)) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
