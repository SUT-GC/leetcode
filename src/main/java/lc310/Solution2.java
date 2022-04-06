package lc310;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution2 {

    public static class Edge {
        Node leftNode;
        Node rightNode;

        public Edge(Node leftNode, Node rightNode) {
            if (null != leftNode) {
                this.leftNode = leftNode;
                this.leftNode.putEdge(this);
            }

            if (null != rightNode) {
                this.rightNode = rightNode;
                this.rightNode.putEdge(this);
            }
        }
    }

    public static class Node {
        int num;
        Set<Edge> edges = new HashSet<>();

        public void putEdge(Edge edge) {
            if (edges.contains(edge)) {
                return;
            }

            edges.add(edge);
        }

        public int edgeSize() {
            return this.edges.size();
        }

        public Node(int num) {
            this.num = num;
        }
    }

    private List<Node> nodes = new ArrayList<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 初始化图
        initGraph(n, edges);

        List<Integer> result = new ArrayList<>();

        Integer minDeep = null;
        for (Node node : nodes) {
            int deep = findDeep(node, new HashSet<>());
            if (null == minDeep || deep == minDeep) {
                minDeep = deep;
                result.add(node.num);
            } else if (deep < minDeep) {
                result = new ArrayList<>();
                result.add(node.num);
                minDeep = deep;
            }
        }

        Collections.sort(result);
        return result;
    }

    private int findDeep(Node node, Set<Edge> used) {
        // 如果是叶子节点了，就返回0
        if (null == node.edges || used.containsAll(node.edges)) {
            return 0;
        }

        // 否则，深度加一，然后遍历所有孩子
        Integer childMax = 0;
        for (Edge edge : node.edges) {
            if (used.contains(edge)) {
                continue;
            }

            used.add(edge);

            if (edge.leftNode == node) {
                childMax = Math.max(childMax, findDeep(edge.rightNode, used));
            } else {
                childMax = Math.max(childMax, findDeep(edge.leftNode, used));
            }
        }

        return childMax + 1;
    }

    private void initGraph(int n, int[][] edges) {
        Map<Integer, Node> numMapNode = new HashMap<>();
        // 初始化节点
        for (int i = 0; i < n; i++) {
            numMapNode.put(i, new Node(i));
        }

        // 将节点和边挂起来
        List<Edge> allEdges = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            Edge edge = new Edge(numMapNode.get(edges[i][0]), numMapNode.get(edges[i][1]));
            allEdges.add(edge);
        }

        this.nodes = numMapNode.values().stream()
                .sorted((o1, o2) -> Integer.compare(o2.edgeSize(), o1.edgeSize())).collect(Collectors.toList());
    }
}
