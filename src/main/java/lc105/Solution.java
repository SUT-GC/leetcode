package lc105;

import mate.TreeNode;

import java.util.Arrays;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode();
        int rootV = preorder[0];
        root.setVal(rootV);

        int rootI = findIndexInInorder(rootV, inorder);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootI);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootI + 1, inorder.length);

        if (leftInorder.length > 0) {
            int[] leftPreOrder = findPreOrder(leftInorder, preorder, true);
            root.setLeft(buildTree(leftPreOrder, leftInorder));
        }

        if (rightInorder.length > 0) {
            int[] rightPreOrder = findPreOrder(rightInorder, preorder, false);
            root.setRight(buildTree(rightPreOrder, rightInorder));
        }

        return root;
    }

    private int[] findPreOrder(int[] inorder, int[] preorder, boolean left) {
        if (left) {
            return Arrays.copyOfRange(preorder, 1, inorder.length + 1);
        } else {
            return Arrays.copyOfRange(preorder, preorder.length - inorder.length, preorder.length);
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
