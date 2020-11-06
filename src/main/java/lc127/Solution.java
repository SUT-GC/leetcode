package lc127;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public int MAX_VALUE = 10000000;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // conner case
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        int ans = findNextWord(beginWord, endWord, wordList);

        if (ans >= MAX_VALUE) {
            return 0;
        } else {
            return ans + 1;
        }

    }

    public int findNextWord(String start, String end, List<String> wordList) {
        int min = 10000000;

        for (String next : wordList) {
            boolean isValidNext = isValidNextWord(start, next);
            // 如果已经找到了有效的，且只变更了一次，则返回
            if (isValidNext && end.equals(next)) {
                return 1;
            }

            // 如果是有效的，就以此为基准，继续寻找
            if (isValidNext) {
                List<String> nextWorld = wordList.stream().filter(p -> !p.equals(next)).collect(Collectors.toList());
                min = Math.min(findNextWord(next, end, nextWorld) + 1, min);
            }
        }

        return min;
    }

    public boolean isValidNextWord(String start, String end) {
        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }
}
