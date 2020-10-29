package lc129;

import mate.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode() {{
            val = 4;
            left = new TreeNode() {{
                val = 9;
                left = new TreeNode() {{
                    val = 5;
                }};
                right = new TreeNode() {{
                    val = 1;
                }};
            }};
            right = new TreeNode() {{
                val = 0;
            }};
        }};

        System.out.println(new Solution().sumNumbers(tree1));
    }
}
