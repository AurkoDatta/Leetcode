package org.LeetCodeSols.SlidingWindow;

/***
 * count the vowels in the very first window of size k to get things started
 * slide the window one character at a time after that, adding whatever char just entered on the right and dropping whatever char just left on the left
 * max just keeps track of the biggest count seen across every window checked
 * isVowel is a small helper that checks the current char against the five vowels
 */

public class num1456 {
    public static int maxVowels(String s, int k) {
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        int max = count;

        for (int right = k; right < s.length(); right++) {
            if (isVowel(s.charAt(right))) {
                count++;
            }
            if (isVowel(s.charAt(right - k))) {
                count--;
            }
            max = Math.max(max, count);
        }

        return max;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
