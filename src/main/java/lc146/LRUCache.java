package lc146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int timeCount = 0;
    int cap = 0;

    Map<Integer, Integer> cache = null;
    Map<Integer, Integer> lruMap = new HashMap<>();


    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.lruMap = new HashMap<>(capacity);
        this.cap = capacity;
    }

    public int get(int key) {
        lruCount(key);
        return this.cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        this.cache.put(key, value);
        lruCount(key);
        dieOut();
    }

    public void lruCount(int key) {
        timeCount++;
        lruMap.put(key, timeCount);
    }

    public void dieOut() {
        if (this.cache.size() <= this.cap) {
            return;
        }

        int minCount = Integer.MAX_VALUE;
        Integer minKey = null;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : this.lruMap.entrySet()) {
            if (integerIntegerEntry.getValue() < minCount) {
                minCount = integerIntegerEntry.getValue();
                minKey = integerIntegerEntry.getKey();
            }
        }

        if (minKey != null) {
            this.cache.remove(minKey);
            this.lruMap.remove(minKey);
        }
    }
}
