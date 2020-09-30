package lc235;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mate.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode result = root;
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            result = queue.removeFirst();
            if (isChildNode(result.left, p) && isChildNode(result.left, q)) {
                queue.addLast(result.left);
            }
            if (isChildNode(result.right, p) && isChildNode(result.right, q)) {
                queue.addLast(result.right);
            }
        }

        return result;
    }

    public boolean isChildNode(TreeNode root, TreeNode p) {
        if (null == root) {
            return false;
        }

        if (root.val == p.val) {
            return true;
        }

        return isChildNode(root.left, p) || isChildNode(root.right, p);
    }
}
