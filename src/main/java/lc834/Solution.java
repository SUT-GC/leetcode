package lc834;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[] ans;
    int[] dp;
    int[] sz;

    List<List<Integer>> graph;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        ans = new int[N];
        dp = new int[N];
        sz = new int[N];

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            graph.get(parent).add(child);
            graph.get(child).add(parent); // 构造无向图
        }

        return null;

    }

    public void dfs(int parent, int f) {
        for (int child : graph.get(parent)) {
            if (child == f) { // 去重复（怕成死环）
                continue;
            }

            dfs(child, parent);
            dp[parent] += dp[child] + sz[child];
            sz[parent] += sz[child];
        }
    }
}
