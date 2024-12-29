package org.LeetCodeSols.HashMaps;

import java.util.HashMap;
import java.util.Map;

/***
 * First loop through all the characters in the string and place them in a HashMap with their number of occurences
 * If the map contains all the required letters for the word ballon, proceed imto the while loop
 * Else, return 0
 * The while loop runs under the condition that the minimum number of letters for atleast one "balloon" is present
 * When present, increment the balloon variable by 1
 * Subtract the all the letters required for one "balloon" along with the number of occurences required from the HashMap
 * After the while loop ends, and you're out of the if statement, return the balloon variable
 */

public class num1189 {
    public static int maxNumberOfBalloons(String text) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
        }

        int balloons = 0;

        if (map.containsKey('b') && map.containsKey('a') && map.containsKey('l') && map.containsKey('o') && map.containsKey('n')) {
            while (map.get('b') >= 1 && map.get('a') >= 1 && map.get('l') >= 2 && map.get('o') >= 2 && map.get('n') >= 1) {
                balloons++;
                map.put('b', map.get('b') - 1);
                map.put('a', map.get('a') - 1);
                map.put('l', map.get('l') - 2);
                map.put('o', map.get('o') - 2);
                map.put('n', map.get('n') - 1);
            }
        } else {
            return 0;
        }

        return balloons;

    }

    public static void main(String[] args) {
        String text = "loonbalxballpoonballoo";

        System.out.println(maxNumberOfBalloons(text));
    }
}
