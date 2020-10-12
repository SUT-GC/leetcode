package lc530;

import mate.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode() {{
            val = 1;
            right = new TreeNode() {{
                val = 5;
                left = new TreeNode() {{
                    val = 3;
                }};
            }};
        }};

        System.out.println(new Solution().getMinimumDifference(root));
    }
}
