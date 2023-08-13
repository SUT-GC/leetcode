package lc_offser_36;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }

        List<Node> sorted = dfs(root);

        for (int i = 1; i < sorted.size(); i++) {
            Node n = sorted.get(i);
            n.left = sorted.get(i - 1);
            n.left.right = n;
        }

        sorted.get(sorted.size() - 1).right = sorted.get(0);
        sorted.get(0).left = sorted.get(sorted.size() - 1);

        return sorted.get(0);
    }

    private List<Node> dfs(Node root) {
        if (null == root) {
            return new ArrayList<>();
        }

        List<Node> result = new ArrayList<>();
        result.addAll(dfs(root.left));
        result.add(root);
        result.addAll(dfs(root.right));

        return result;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node4.left = node2;
        node4.right = node5;

        node2.left = node1;
        node2.right = node3;

        Solution solution = new Solution();

        System.out.println(solution.treeToDoublyList(node4));
    }
}
