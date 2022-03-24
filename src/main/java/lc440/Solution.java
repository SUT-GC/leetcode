package lc440;


import java.util.stream.IntStream;

class Solution {
    public int findKthNumberV2(int n, int k) {
        return IntStream.range(1, n + 1).mapToObj(String::valueOf).sorted().skip(k - 1).findFirst().map(Integer::valueOf).orElse(0);
    }

    public int findKthNumber(int n, int k) {
        int p = 1;
        int prefix = 1;
        while (p < k) {
            int count = countN(prefix, n); // 统计当前节点的子节点数量（算上自己）
            if (p + count > k) { // 如果 k 在当前节点树下
                prefix *= 10; // 搜索下一层
                p++; // 搜索的节点+1（直到搜索的节点数量==k 就搜索完了）
            } else if (p + count <= k) { // 如果 k 不在当前节点树下
                prefix++; // 搜索相邻的节点树
                p += count; // 把搜索过的所有节点都统计上
            }
        }

        return prefix;
    }

    public int countN(int prefix, int n) {
        int count = 0;
        for (long cur = prefix, next = prefix + 1; cur <= n; cur *= 10, next *= 10) {
            count += Math.min(next, n + 1) - cur;
        }

        return count;
    }
}