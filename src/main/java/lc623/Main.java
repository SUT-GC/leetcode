package lc623;

import mate.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), new TreeNode(6, new TreeNode(5), null));
        Solution solution = new Solution();
        solution.addOneRow(treeNode, 1, 2);
    }
}
