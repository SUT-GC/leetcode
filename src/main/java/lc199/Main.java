package lc199;


import mate.TreeNode;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rightSideView(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4))));
    }
}
