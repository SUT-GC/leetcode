package lc767;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {


    class Part {
        Character character;
        int count;

        public Part(Character character, int count) {
            this.character = character;
            this.count = count;
        }

        public void decr() {
            this.count--;
        }

        public boolean isValid() {
            return this.count > 0;
        }
    }

    public String reorganizeString(String s) {
        if (null == s || s.isEmpty()) {
            return s;
        }

        Queue<Part> queue = init(s);

        StringBuilder ans = new StringBuilder();
        while (queue.size() >= 2) {
            Part first = queue.remove();
            Part second = queue.remove();
            if (ans.length() == 0) {
                ans.append(first.character);
                first.decr();
            } else {
                char endC = ans.charAt(ans.length() - 1);
                if (endC == first.character) {
                    ans.append(second.character);
                    second.decr();
                } else {
                    ans.append(first.character);
                    first.decr();
                }
            }

            if (first.isValid()) {
                queue.offer(first);
            }
            if (second.isValid()) {
                queue.offer(second);
            }
        }

        if (queue.isEmpty()) {
            return ans.toString();
        }

        Part first = queue.remove();
        if (ans.length() == 0 && first.count > 1) {
            return "";
        }

        if (ans.charAt(ans.length() - 1) != first.character && first.count == 1) {
            ans.append(first.character);
            return ans.toString();
        } else {
            return "";
        }
    }

    private Queue<Part> init(String s) {
        Queue<Part> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.count, o1.count));

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        countMap.forEach((k, v) -> queue.add(new Part(k, v)));

        return queue;
    }

}
