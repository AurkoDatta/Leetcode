package org.LeetCodeSols.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class num140 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return helper(s, 0, words, memo);
    }

    private static List<String> helper(String s, int start, Set<String> words, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();
        if (start == s.length()) {
            result.add("");
            return result;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (words.contains(word)) {
                for (String suffix : helper(s, end, words, memo)) {
                    result.add(suffix.isEmpty() ? word : word + " " + suffix);
                }
            }
        }

        memo.put(start, result);
        return result;
    }
}
