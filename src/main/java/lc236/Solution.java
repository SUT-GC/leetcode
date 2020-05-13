package lc236;

import mate.TreeNode;
import utils.TreeUtils;

import java.util.*;

public class Solution {
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, Integer> nodeWithParent = new HashMap<>();
        Map<Integer, TreeNode> valueMapTreeNode = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            valueMapTreeNode.put(node.getVal(), node);
            if (node.getLeft() != null) {
                nodeWithParent.put(node.getLeft().getVal(), node.getVal());
                stack.addFirst(node.getLeft());
            }
            if (node.getRight() != null) {
                nodeWithParent.put(node.getRight().getVal(), node.getVal());
                stack.addFirst(node.getRight());
            }
        }

        Integer tmp = p.getVal();
        list.add(tmp);
        while (nodeWithParent.get(tmp) != null) {
            list.add(nodeWithParent.get(tmp));
            tmp = nodeWithParent.get(tmp);
        }

        tmp = q.getVal();
        if (nodeWithParent.get(tmp) == null) {
            for (Integer l : list) {
                if (l.equals(q.getVal())) {
                    return valueMapTreeNode.get(l);
                }
            }
        } else {
            while (nodeWithParent.get(tmp) != null) {
                for (Integer l : list) {
                    if (l.equals(nodeWithParent.get(tmp))) {
                        return valueMapTreeNode.get(l);
                    }
                }
                tmp = nodeWithParent.get(tmp);
            }
        }


        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (TreeUtils.isChildTreeOnlyValue(root, p) && TreeUtils.isChildTreeOnlyValue(root, q)) {
            TreeNode parentNode = lowestCommonAncestor(root.getLeft(), p, q);
            if (parentNode == null) {
                parentNode = lowestCommonAncestor(root.getRight(), p, q);
            }

            return parentNode == null ? root : parentNode;
        } else {
            return null;
        }
    }
}
