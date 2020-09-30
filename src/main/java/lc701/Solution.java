package lc701;

import mate.TreeNode;

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            root = new TreeNode(val);
        }

        insert(root, root, val, null);

        return root;
    }

    public void insert(TreeNode root, TreeNode node, int val, Boolean left) {
        if (node == null) {
            node = new TreeNode(val);
            if (left) {
                root.left = node;
            } else {
                root.right = node;
            }
        }

        if (node.val > val) {
            insert(node, node.left, val, true);
        }

        if (node.val < val) {
            insert(node, node.right, val, false);
        }
    }
}
