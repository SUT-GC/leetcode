package lc0404;

import mate.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = treeHeight(root.getLeft());
        int rightHeight = treeHeight(root.getRight());

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.getLeft()) && isBalanced(root.getRight());
    }

    public int treeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = treeHeight(node.getLeft());
        int rightHeight = treeHeight(node.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
