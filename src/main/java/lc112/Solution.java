package lc112;

import mate.TreeNode;

public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        // 为了解决corner test
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        sum -= root.val;
        if (root.left != null && root.right == null) {
            return hasPathSum(root.left, sum);
        }

        if (root.right != null && root.left == null) {
            return hasPathSum(root.right, sum);
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

    }
}
