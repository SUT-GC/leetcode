package lc514;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    Map<Character, List<Integer>> charMapIndex = null;
    Map<String, Integer> cache = null;

    public int findRotateSteps(String ring, String key) {
        if (null == ring || null == key || ring.length() <= 0 || key.length() <= 0) {
            return 0;
        }

        initCharMap(ring);

        return dfs(ring, key, 0, 0) + key.length();
    }

    private int dfs(String ring, String key, int ringI, int keyI) {
        if (keyI >= key.length()) {
            return 0;
        }

        String cacheKey = genCacheKey(ring, key, ringI, keyI);
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        int ans = Integer.MAX_VALUE;
        Character keyChar = key.charAt(keyI);
        for (Integer targetI : charMapIndex.get(keyChar)) {
            int step1 = Math.abs(ringI - targetI);
            int step2 = ring.length() - Math.abs(ringI - targetI);
            int stepMin = Math.min(step1, step2);

            ans = Math.min(ans, stepMin + dfs(ring, key, targetI, keyI + 1));
        }

        cache.put(cacheKey, ans);
        return ans;
    }

    private String genCacheKey(String ring, String key, int ringI, int keyI) {

        return String.format("%s-%s-%s-%s", ring, key, ringI, keyI);
    }

    private void initCharMap(String key) {
        charMapIndex = new HashMap<>();
        for (int i = 0; i < key.length(); i++) {
            Character character = key.charAt(i);
            if (charMapIndex.containsKey(character)) {
                charMapIndex.get(character).add(i);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                charMapIndex.put(character, indexes);
            }
        }

        cache = new HashMap<>();
    }
}
