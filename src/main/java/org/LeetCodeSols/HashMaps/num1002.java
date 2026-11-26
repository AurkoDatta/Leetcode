package org.LeetCodeSols.HashMaps;

import java.util.ArrayList;
import java.util.List;

public class num1002 {
    public static List<String> commonChars(String[] words) {
        int[] minCounts = new int[26];
        for (int i = 0; i < 26; i++) {
            minCounts[i] = Integer.MAX_VALUE;
        }

        for (String word : words) {
            int[] counts = new int[26];
            for (char c : word.toCharArray()) {
                counts[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minCounts[i] = Math.min(minCounts[i], counts[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minCounts[i]; j++) {
                result.add(String.valueOf((char) ('a' + i)));
            }
        }

        return result;
    }
}
