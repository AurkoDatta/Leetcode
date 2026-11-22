package org.LeetCodeSols.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num981 {
    private static class Entry {
        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private final Map<String, List<Entry>> store;

    public num981() {
        store = new HashMap<>();
    }

    public void set(String key, int timestamp, String value) {
        store.putIfAbsent(key, new ArrayList<>());
        store.get(key).add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) {
            return "";
        }

        List<Entry> entries = store.get(key);
        int left = 0;
        int right = entries.size() - 1;
        int resultIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (entries.get(mid).timestamp <= timestamp) {
                resultIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return resultIndex == -1 ? "" : entries.get(resultIndex).value;
    }
}
