package lc310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

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

        public Node findNextNode(Node node) {
            if (leftNode == node) {
                return rightNode;
            }
            if (rightNode == node) {
                return leftNode;
            }

            return null;
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

    private Set<Node> allNodes = new HashSet<>();
    private Set<Edge> allEdges = new HashSet<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 初始化图
        initGraph(n, edges);

        while (true) {
            // 如果只有一个叶子节点了，则结果就是这个节点
            if (allNodes.size() == 1 || allNodes.size() == 2) {
                List<Integer> result = new ArrayList<>();
                allNodes.forEach(p -> result.add(p.num));
                Collections.sort(result);
                return result;
            }

            // 找叶子节点
            List<Node> nodes = allNodes.stream().filter(node -> node.edgeSize() == 1).collect(Collectors.toList());


            // 开始剪叶子节点
            for (Node node : nodes) {
                removeThisNode(node);
            }
        }


    }

    private void removeThisNode(Node node) {
        Edge edge = node.edges.stream().findFirst().orElse(null);
        if (null == edge) {
            return;
        }

        // 删掉这条边
        edge.findNextNode(node).edges.remove(edge);
        this.allEdges.remove(edge);
        // 删掉这个节点
        this.allNodes.remove(node);
    }

    private void initGraph(int n, int[][] edges) {
        Map<Integer, Node> numMapNode = new HashMap<>();
        // 初始化节点
        for (int i = 0; i < n; i++) {
            numMapNode.put(i, new Node(i));
        }

        this.allNodes.addAll(numMapNode.values());

        // 将节点和边挂起来
        for (int i = 0; i < edges.length; i++) {
            Edge edge = new Edge(numMapNode.get(edges[i][0]), numMapNode.get(edges[i][1]));
            this.allEdges.add(edge);
        }
    }
}
