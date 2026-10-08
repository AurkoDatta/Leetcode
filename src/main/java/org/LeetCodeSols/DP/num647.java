package org.LeetCodeSols.DP;

/***
 * every palindrome has a center, either a single character for odd length ones or the gap between two characters for even length ones
 * expand gets called from every possible center, counting how far it can stretch outward while the characters on both sides keep matching
 * expand(s, i, i) starts left and right on the same index, so it covers every odd length palindrome centered on that character
 * expand(s, i, i + 1) starts right one past left, so it covers every even length palindrome sitting between those two characters
 * each step inside expand where the two sides still match grows count by one and pushes left and right another step outward, stopping once they go out of bounds or stop matching
 * summing up what every center contributes gives the total number of palindromic substrings in the whole string
 */

public class num647 {
    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);
            count += expand(s, i, i + 1);
        }

        return count;
    }

    private static int expand(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
