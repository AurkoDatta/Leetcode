package org.LeetCodeSols.Set3;

public class num344 {
    public void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] s, int left, int right) {
        if (left >= right) return;
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverse(s, left + 1, right - 1);
    }


    public static void main(String[] args) {
        System.out.println(reverseString("abcdefg"));
    }
}
