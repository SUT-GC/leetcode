package lc129;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import mate.TreeNode;

public class Solution {
    public int sumNumbers(TreeNode root) {
        List<String> paths = findAllPath(root);

        List<Integer> pathNum = convertToNum(paths);

        return sum(pathNum);
    }

    private int sum(List<Integer> pathNum) {

        return pathNum.stream().reduce(Integer::sum).orElse(0);
    }

    private List<Integer> convertToNum(List<String> paths) {

        return paths.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    private List<String> findAllPath(TreeNode root) {
        List<String> paths = new ArrayList<>();
        Set<TreeNode> read = new HashSet<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        if (root == null) {
            return paths;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.getLast();

            // 一直压左节点入栈
            if (null != node.left && !read.contains(node.left)) {
                stack.addLast(node.left);
                continue;
            }

            // 没有左节点，就压右节点入栈
            if (null != node.right && !read.contains(node.right)) {
                stack.addLast(node.right);
                continue;
            }

            // 叶子节点处理 1.储存路径; 2.标记读过; 3.弹出stack
            if (null == node.left && null == node.right) {
                paths.add(stack.stream().map(p -> p.val + "").collect(Collectors.joining("")));
            }

            read.add(node);
            stack.removeLast();
        }

        return paths;
    }
}
