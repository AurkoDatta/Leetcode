package org.LeetCodeSols.Set2;

import java.util.HashMap;
import java.util.Map;

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
