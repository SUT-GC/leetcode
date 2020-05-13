package lc106;

import mate.TreeNode;

import java.util.Arrays;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode();
        int rootV = postorder[postorder.length - 1];
        root.setVal(rootV);

        int rootI = findIndexInInorder(rootV, inorder);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootI);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootI + 1, inorder.length);

        if (leftInorder.length > 0) {
            int[] leftPostOrder = findPreOrder(leftInorder, postorder, true);
            root.setLeft(buildTree(leftInorder, leftPostOrder));
        }

        if (rightInorder.length > 0) {
            int[] rightPostOrder = findPreOrder(rightInorder, postorder, false);
            root.setRight(buildTree(rightInorder, rightPostOrder));
        }

        return root;
    }

    private int[] findPreOrder(int[] inorder, int[] postorder, boolean left) {
        if (left) {
            return Arrays.copyOfRange(postorder, 0, inorder.length);
        } else {
            return Arrays.copyOfRange(postorder, postorder.length - inorder.length - 1, postorder.length - 1);
        }
    }

    private int findIndexInInorder(int v, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == v) {
                return i;
            }
        }

        return -1;
    }
}
