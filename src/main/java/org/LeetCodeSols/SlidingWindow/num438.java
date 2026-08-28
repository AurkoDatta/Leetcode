package org.LeetCodeSols.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

/***
 * count up the letters in p, that's the target we are looking for
 * slide a window the same length as p across s, keeping its own letter counts
 * add the new letter on the right and drop the old one on the left as the window moves
 * whenever the window counts match the target counts exactly, the start index is an anagram
 */

public class num438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }

        if (matches(need, window)) {
            result.add(0);
        }

        for (int right = p.length(); right < s.length(); right++) {
            window[s.charAt(right) - 'a']++;
            window[s.charAt(right - p.length()) - 'a']--;

            if (matches(need, window)) {
                result.add(right - p.length() + 1);
            }
        }

        return result;
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
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}
