package lc99;

import mate.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        Solution solution = new Solution();
        solution.recoverTree(root);

        System.out.println(root);
    }
}
