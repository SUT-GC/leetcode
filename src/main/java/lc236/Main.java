package lc236;

import gen.TreeGen;
import mate.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeGen treeGen = new TreeGen();
        TreeNode node1 = treeGen.gen236_1();
        TreeNode node2 = treeGen.gen236_2();
        TreeNode node3 = treeGen.gen236_3();

        Solution solution = new Solution();
        System.out.println(solution.lowestCommonAncestorV2(node1, node2, node3));
    }
}
