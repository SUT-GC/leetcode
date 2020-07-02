package lc378;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int[] nums : matrix) {
            for (int num : nums) {
                queue.add(num);
            }
        }

        while (--k > 0) {
            queue.poll();
        }

        return queue.poll();
    }
}
