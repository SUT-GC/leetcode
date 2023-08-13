package lc114;

import java.util.ArrayList;
import java.util.List;
import mate.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> allNode = new ArrayList<>();

        dfs(root, allNode);

        for (int i = 0; i < allNode.size() - 1; i++) {
            allNode.get(i).left = null;
            allNode.get(i).right = allNode.get(i + 1);
        }
    }

    public void dfs(TreeNode root, List<TreeNode> allNode) {
        if (null == root) {
            return;
        }

        allNode.add(root);
        dfs(root.left, allNode);
        dfs(root.right, allNode);
    }
}
