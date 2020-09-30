package lc701;

import mate.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode() {{
            val = 4;
            left = new TreeNode() {{
                val = 2;
                left = new TreeNode() {{
                    val = 1;
                }};
                right = new TreeNode() {{
                    val = 3;
                }};
            }};
            right = new TreeNode() {{
                val = 7;
            }};
        }};
        System.out.println(new Solution().insertIntoBST(root, 5));
    }
}
