package org.LeetCodeSols.Arrays;

import java.util.HashMap;
import java.util.Map;

/***
 * First we create a dictionary (or HashMap) of all the Roman numbers and their corresponding integer value
 * We then run a loop through the input string
 * If the value of the character at index of the loop is smaller than the next character
 * We subtract the following value from the result
 * Else, we add that value to the result
 */

public class num13 {
    public int romanToInt(String s) {

        int result = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result -= map.get(s.charAt(i));
            }else {
                result += map.get(s.charAt(i));
            }
        }
        return result + map.get(s.charAt(s.length() - 1));
    }
}
