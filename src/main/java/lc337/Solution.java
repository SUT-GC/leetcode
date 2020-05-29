package lc337;

import mate.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Solution {
    Map<TreeNode, Integer> cache = new HashMap<>();

    public int rob(TreeNode root) {
        // 如果当前节点是空，咋返回0
        if (root == null) {
            return 0;
        }
        // 先看缓存
        if (cache.get(root) != null) {
            return cache.get(root);
        }

        // 打结当前节点和下个节点的下个a节点
        int doIt = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) + (root.right == null ? 0 : rob(root.right.right) + rob(root.right.left));
        // 不打结当前节点，则打结下个节点
        int notDoIt = rob(root.left) + rob(root.right);

        // 取个最大值
        int max = Math.max(doIt, notDoIt);
        // 放入缓存
        cache.put(root, max);

        return max;
    }
}
