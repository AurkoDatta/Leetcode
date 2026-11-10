package org.LeetCodeSols.HashMaps;

import java.util.HashSet;
import java.util.Set;

/***
 * replacing n with the sum of the squares of its digits over and over either eventually lands on 1, or falls into a loop that never reaches 1
 * seen keeps track of every value n has passed through so far, which is what makes a loop detectable instead of running forever
 * the loop keeps transforming n as long as it hasn't hit 1 and hasn't shown up before, adding the current n to seen right before moving on to the next one
 * if n reaches 1 the loop exits with a happy number, and if n repeats a value already in seen the loop exits too, just stuck in a cycle that will never produce a 1
 * getNext peels n apart one digit at a time with % 10 and / 10, squaring and summing each digit to build the next value in the chain
 */

public class num202 {
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    private static int getNext(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}
