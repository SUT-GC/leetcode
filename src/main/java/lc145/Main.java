package lc145;

import mate.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode() {{
            val = 3;
            right = new TreeNode() {{
                val = 2;
            }};
            left = new TreeNode() {{
                val = 1;
            }};
        }};

        System.out.println(new Solution().postorderTraversal(treeNode));
    }
}
