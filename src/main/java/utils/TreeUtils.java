package utils;

import gen.TreeGen;
import mate.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {
    public static String firstRootPrintWithNullToStr(TreeNode treeNode) {
        if (treeNode == null) {
            return "#";
        }

        return String.format("%s,%s,%s", treeNode.getVal(), firstRootPrintWithNullToStr(treeNode.getLeft()), firstRootPrintWithNullToStr(treeNode.getRight()));
    }

    public static List<String> firstRootPrintWithNullToList(TreeNode treeNode) {
        if (treeNode == null) {
            return new ArrayList<String>() {{
                add("#");
            }};
        }

        ArrayList<String> list = new ArrayList<>();
        list.add(treeNode.getVal() + "");
        list.addAll(firstRootPrintWithNullToList(treeNode.getLeft()));
        list.addAll(firstRootPrintWithNullToList(treeNode.getRight()));

        return list;
    }

    public static boolean isChildTreeOnlyValue(TreeNode a, TreeNode b) {
        if (a == null) {
            return false;
        }

        if (b == null) {
            return false;
        }

        if (a.getVal() == b.getVal()) {
            return true;
        }

        return isChildTreeOnlyValue(a.getLeft(), b) || isChildTreeOnlyValue(a.getRight(), b);
    }

    public static void main(String[] args) {
        TreeGen treeGen = new TreeGen();
        TreeNode node1 = treeGen.gen236_1();
        TreeNode node2 = treeGen.gen236_2();

        System.out.println(isChildTreeOnlyValue(node1, node2));
    }
}
