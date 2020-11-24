package lc222;

import mate.TreeNode;

public class Solution {

    public int countNodes(TreeNode root) {
        return null == root ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }

}
