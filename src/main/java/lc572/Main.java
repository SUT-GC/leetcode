package lc572;

import gen.TreeGen;
import mate.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeGen treeGen = new TreeGen();
        TreeNode tree1 = treeGen.gen572_1();
        TreeNode tree2 = treeGen.gen572_2();


        Solution solution = new Solution();
        System.out.println(solution.isSubtree(tree1, tree2));
    }
}
