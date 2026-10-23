package org.LeetCodeSols.TwoPointer;

/***
 * every palindrome has a center, either a single character for odd length or the gap between two characters for even length, so trying both center types at every index covers every possible palindrome in the string
 * expand handles one center at a time, pushing left and right outward as long as the characters on both sides keep matching, and returns how long that stretch turned out to be once it stops
 * len1 checks the odd center sitting right on i, len2 checks the even center sitting between i and i+1, and whichever one comes back longer is the real candidate for this index
 * whenever that candidate beats the best length found so far, start and end get moved to bracket it, using the odd/even math to land on the right substring boundaries either way
 * by the time every index has had a turn as a center, start and end mark out the longest palindrome seen across the whole string, so substring on those bounds gives the answer
 */

public class num5 {
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
