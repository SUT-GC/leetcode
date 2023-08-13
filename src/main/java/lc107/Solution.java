package lc107;

import java.util.LinkedList;
import java.util.List;
import mate.TreeNode;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (null == root) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            List<Integer> oneLevel = new LinkedList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode first = queue.removeFirst();
                oneLevel.add(first.val);

                if (null != first.left) {
                    queue.addLast(first.left);
                }

                if (null != first.right) {
                    queue.addLast(first.right);
                }
            }
            result.add(0, oneLevel);
        }

        return result;
    }
}
