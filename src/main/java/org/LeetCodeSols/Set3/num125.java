package org.LeetCodeSols.Set3;

public class num125 {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int l = 0, r = s.length() - 1;

        /***
         * Use pointers from left and right to check if both characters are equal
         */


        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("madama"));
    }
}
