package lc144;

import java.util.ArrayList;
import java.util.List;
import mate.TreeNode;

public class Solution {
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);

        return ans;
    }

    private void preOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        ans.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
