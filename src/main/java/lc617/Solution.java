package lc617;

import mate.TreeNode;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1) {
            return t2;
        }

        if (null == t2) {
            return t1;
        }

        TreeNode node = new TreeNode();
        node.val = t1.val + t2.val;

        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);

        return node;
    }
}
