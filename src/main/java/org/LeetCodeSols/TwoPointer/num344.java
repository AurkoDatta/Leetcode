package org.LeetCodeSols.TwoPointer;

/***
 * Use a recursive reverse function to reverse the full string
 * The reverse functions takes in two inputs along with the input array to use as pointers
 * use a temp variable to switch the letters at the left and right pointer index
 * Run the function recursively while incrementing the left pointer by 1, and decrementing the right pointer by 1.
 */

public class num344 {
    public static void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }

    private static void reverse(char[] s, int left, int right) {
        if (left >= right) return;
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverse(s, left + 1, right - 1);
    }



}
