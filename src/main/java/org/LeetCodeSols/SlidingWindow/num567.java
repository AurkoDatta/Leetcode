package org.LeetCodeSols.SlidingWindow;

/***
 * count up the letters in s1, thats the pattern we need to find
 * slide a window the same length as s1 across s2, keeping its own letter counts
 * whenever the two count arrays match exactly there is a permutation sitting in that window
 * add the new letter on the right and drop the old one on the left instead of recounting every time
 */

public class num567 {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if (matches(need, window)) {
            return true;
        }

        for (int right = s1.length(); right < s2.length(); right++) {
            window[s2.charAt(right) - 'a']++;
            window[s2.charAt(right - s1.length()) - 'a']--;

            if (matches(need, window)) {
                return true;
            }
        }

        return false;
    }

    private static boolean matches(int[] need, int[] window) {
        for (int i = 0; i < 26; i++) {
            if (need[i] != window[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
