package lc623;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mate.TreeNode;

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        List<List<TreeNode>> levels = level(root);

        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            root = node;
        } else if (depth <= levels.size()) {
            for (int i = 0; i < levels.size(); i++) {
                if (i == depth - 1) {
                    List<TreeNode> parentLevel = levels.get(i - 1);

                    for (TreeNode parentNode : parentLevel) {
                        TreeNode lnode = new TreeNode(val);
                        lnode.left = parentNode.left;
                        parentNode.left = lnode;

                        TreeNode rnode = new TreeNode(val);
                        rnode.right = parentNode.right;
                        parentNode.right = rnode;
                    }

                }
            }
        } else {
            List<TreeNode> parentNodes = levels.get(levels.size() - 1);
            for (TreeNode parentNode : parentNodes) {
                parentNode.left = new TreeNode(val);
                parentNode.right = new TreeNode(val);
            }
        }

        return root;
    }

    public List<List<TreeNode>> level(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> level = new LinkedList<>();
            while (size > 0) {
                TreeNode head = queue.remove(0);
                level.add(head);
                if (null != head.left) {
                    queue.add(head.left);
                }
                if (null != head.right) {
                    queue.add(head.right);
                }
                size--;
            }
            result.add(level);
        }

        return result;
    }
}