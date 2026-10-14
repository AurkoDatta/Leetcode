package org.LeetCodeSols.TwoPointer;

/***
 * left and right close in from both ends of the string, and as long as the characters they point at match, a palindrome doesn't need any help there yet
 * the first mismatch is the only chance to delete a character, so from that point there are exactly two strings worth checking: the one with left skipped, and the one with right skipped
 * isPalindrome just runs the same closing-in check on a sub-range with no deletions allowed, so it's reused for both of those candidate strings
 * if either skip produces a clean palindrome the whole string is a valid one deletion away from being a palindrome, so true is returned the moment one of them succeeds
 * if left and right meet without ever mismatching, the string was already a palindrome and no deletion was needed at all
 */

public class num680 {
    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
