package lc199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mate.TreeNode;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        if (null == root){
            return result;
        }

        List<List<TreeNode>> levels = level(root);



        for (int i = 0; i < levels.size(); i++) {
            List<TreeNode> level = levels.get(i);
            result.add(level.get(level.size() - 1).val);
        }

        return result;
    }

    public void dfs(TreeNode root, List<TreeNode> allNode) {
        if (null == root) {
            return;
        }

        dfs(root.left, allNode);
        allNode.add(root);
        dfs(root.right, allNode);
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

    public int calTreeHeight(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return Math.max(1 + calTreeHeight(root.left), 1 + calTreeHeight(root.right));
    }
}