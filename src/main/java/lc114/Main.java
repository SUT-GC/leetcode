package lc114;


import mate.TreeNode;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.flatten(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6))));
    }
}
