package lc501;

import mate.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode() {{
            setVal(1);

        }};

        System.out.println(new Solution().findMode(treeNode));
    }
}
