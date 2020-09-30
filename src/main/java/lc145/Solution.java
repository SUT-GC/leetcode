package lc145;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mate.TreeNode;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();

        queue.addFirst(root);

        while (!queue.isEmpty()) {
            TreeNode head = queue.removeFirst();

            if (null != head.left) {
                queue.addFirst(head.left);
            }

            if (null != head.right) {
                queue.addFirst(head.right);
            }

            result.addFirst(head.val);
        }

        return new ArrayList<>(result);
    }
}
