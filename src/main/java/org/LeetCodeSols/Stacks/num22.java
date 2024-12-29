package org.LeetCodeSols.Stacks;

import java.util.ArrayList;
import java.util.List;

public class num22 {
    public List<String> generateParenthesis(int n) {
        // Create a list to store all valid combinations of parentheses
        List<String> res = new ArrayList<String>();

        // Start the recursive function with initial values:
        // res: the result list to store valid combinations
        // left: the count of '(' used so far (initially 0)
        // right: the count of ')' used so far (initially 0)
        // s: the current string being built (initially empty)
        // n: the total number of pairs of parentheses
        recurse(res, 0, 0, "", n);

        // Return the list of valid combinations
        return res;
    }

    public void recurse(List<String> res, int left, int right, String s, int n) {
        // Base case: If the current string has reached the maximum length (n * 2),
        // it means we have used all pairs of parentheses, so add it to the result list
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        // Recursive case 1: If the number of '(' used so far is less than n,
        // we can add another '(' to the string and recurse
        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }

        // Recursive case 2: If the number of ')' used so far is less than the number of '(',
        // we can add another ')' to the string and recurse
        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }
}
