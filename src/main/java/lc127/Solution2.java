package lc127;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // conner case
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        List<Character> chars = backup();

        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.addFirst(beginWord);


        int res = 1;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                String originStr = queue.removeFirst();
                for (Character aChar : chars) {
                    for (int i = 0; i < originStr.length(); i++) {
                        String temp = originStr.substring(0, i) + aChar + originStr.substring(i + 1, originStr.length());
                        if (wordSet.contains(temp)) {
                            if (!visited.contains(temp)) {
                                if (temp.equals(endWord)) {
                                    return res + 1;
                                } else {
                                    queue.addLast(temp);
                                    visited.add(temp);
                                }
                            }
                        }
                    }
                }
            }

            res += 1;
        }

        return 0;
    }

    private List<Character> backup() {
        List<Character> result = new ArrayList<>();

        result.add('a');
        result.add('b');
        result.add('c');
        result.add('d');
        result.add('e');
        result.add('f');
        result.add('g');
        result.add('h');
        result.add('i');
        result.add('j');
        result.add('k');
        result.add('l');
        result.add('m');
        result.add('n');
        result.add('o');
        result.add('p');
        result.add('q');
        result.add('r');
        result.add('s');
        result.add('t');
        result.add('u');
        result.add('v');
        result.add('w');
        result.add('x');
        result.add('y');
        result.add('z');

        return result;
    }

}
