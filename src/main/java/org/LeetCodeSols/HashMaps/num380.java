package org.LeetCodeSols.HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/***
 * indexMap tracks the position each value currently sits at inside values, and values is the actual list of elements that make up the set, so together they let every operation jump straight to the right spot instead of scanning the whole collection
 * insert first checks indexMap to make sure val isn't already present, since this structure represents a set and duplicates aren't allowed, so it returns false right away when the value is already there
 * when val is genuinely new, its position is recorded as whatever index values is about to grow to, and the value itself is appended onto the end of values
 * remove also bails out early with false if val was never present, since there's nothing to take out in that case
 * otherwise the trick is to avoid leaving a hole in the middle of values: the last element in the list gets moved into the slot val used to occupy, indexMap is updated so that moved value now points at its new position, and only then does the now-duplicate last slot get dropped off the end of values
 * val's own entry is removed from indexMap last, once nothing else in the structure still points back at it
 * getRandom just picks a random index inside the current bounds of values and returns whatever sits there, which works because every element in the set occupies exactly one slot in values with no gaps between them
 */

public class num380 {
    private final Map<Integer, Integer> indexMap;
    private final List<Integer> values;
    private final Random random;

    public num380() {
        indexMap = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }

        indexMap.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }

        int index = indexMap.get(val);
        int lastVal = values.get(values.size() - 1);

        values.set(index, lastVal);
        indexMap.put(lastVal, index);
        values.remove(values.size() - 1);
        indexMap.remove(val);
        return true;
    }

    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}
