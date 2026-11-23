package org.LeetCodeSols.HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
