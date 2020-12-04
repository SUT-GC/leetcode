package lc659;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    class Part {
        int num;
        int count;

        public Part(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public void putLast(int num) {
            this.num = num;
            this.count++;
        }
    }

    public boolean isPossible(int[] nums) {
        if (null == nums || nums.length == 0) {
            return false;
        }

        Map<Integer, Queue<Part>> parts = new HashMap<>();

        pull(parts, nums);

        boolean ans = check(parts);

        return ans;
    }

    private void pull(Map<Integer, Queue<Part>> parts, int[] nums) {
        for (int num : nums) {
            // 判断是否能将该字符接到后面
            Queue<Part> beforeNumPars = filterByBeforeNum(parts, num);

            // 没有接的，就自己加一个
            if (null == beforeNumPars || beforeNumPars.isEmpty()) {
                addOne(parts, new Part(num, 1));
                continue;
            }

            // 有能接的，就找count最小的接
            Part minCountPart = findMinCount(beforeNumPars);
            minCountPart.putLast(num);
            addOne(parts, minCountPart);
        }
    }

    private void addOne(Map<Integer, Queue<Part>> parts, Part part) {
        if (parts.containsKey(part.num)) {
            parts.get(part.num).add(part);
            return;
        }

        parts.put(part.num, new PriorityQueue<>(Comparator.comparingInt(o -> o.count)));
        parts.get(part.num).add(part);
    }

    private Part findMinCount(Queue<Part> parts) {
        return parts.remove();
    }

    private Queue<Part> filterByBeforeNum(Map<Integer, Queue<Part>> parts, int num) {

        return parts.get(num - 1);
    }

    private boolean check(Map<Integer, Queue<Part>> parts) {
        if (null == parts || parts.isEmpty()) {
            return false;
        }

        return parts.values().stream().flatMap(Queue::stream).noneMatch(p -> p.count < 3);
    }
}
