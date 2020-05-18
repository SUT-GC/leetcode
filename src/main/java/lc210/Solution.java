package lc210;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 存储 src->dest 所有的dest节点
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        // 存储节点的入度
        int[] indegree = new int[numCourses];
        // 返回值
        int[] result = new int[numCourses];
        // DFS
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];

            // 存储一个节点所有的目标节点
            List<Integer> list = adjList.getOrDefault(src, new ArrayList<>());
            list.add(dest);
            adjList.put(src, list);

            // 存储一个节点的入度
            indegree[dest]++;
        }

        // 先把入度为0的存到Q里面
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.addLast(i);
            }
        }

        int i = 0;
        // 弹出一个节点，把该节点对应的目标节点放进队列，然后判断这个节点是不是没有入度了，如果没有了，就说名是最前面的节点
        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            result[i++] = node;
            for (Integer l : adjList.getOrDefault(node, new ArrayList<>())) {
                indegree[l]--;

                if (indegree[l] == 0) {
                    queue.addLast(l);
                }
            }
        }

        // 如果所有节点都遍历到了，就说明完事了
        if (i == numCourses) {
            return result;
        }

        return new int[0];
    }
}
