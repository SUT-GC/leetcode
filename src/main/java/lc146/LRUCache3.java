package lc146;

import java.util.HashMap;
import java.util.Map;

class LRUCache3 {

    static class Node {
        int k;
        int v;

        Node pre;
        Node next;

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    private int capacity; // 最大容量
    private int size; // 当前容量

    private Map<Integer, Node> cache; // 缓存
    private Node head; // 头哑节点
    private Node tail; // 尾哑节点

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        this.cache = new HashMap<>();

        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    /**
     * 访问
     * <p>
     * 如果节点存在，把访问的这个节点腾挪到头
     * 如果节点不存在，返回-1
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (null == node) {
            return -1;
        }

        // 删除这个节点
        this.delete(node);
        // 插入到头部
        this.insertHead(node);

        return node.v;
    }

    public void put(int key, int value) {
        // 先找缓存
        Node node = cache.get(key);

        if (null != node) {
            // 如果node存在，更新v，并且将它挪到前面
            node.v = value;
            this.delete(node);
            this.insertHead(node);
        } else {
            // 如果node不存在，看看容量够不够，如果不够，则先把尾巴删除
            if (capacity == size) {
                this.delete(tail.pre);
            }

            // 创建一个新节点
            Node newNode = new Node(key, value);
            // 新节点插入到头
            this.insertHead(newNode);
        }
    }

    /**
     * from: head <-> tail
     * to: head <-> node1 <-> tail
     */
    private void insertHead(Node node) {
        Node preNode = this.head;
        Node nextNode = this.head.next;

        node.next = nextNode;
        nextNode.pre = node;

        preNode.next = node;
        node.pre = preNode;

        this.cache.put(node.k, node);

        this.size++;
    }

    /**
     * from: head <-> node1 <-> node2 <-> tail
     * delete node2
     * to: head <-> node1 <-> tail
     */
    private void delete(Node node) {
        Node preNode = node.pre;
        Node nextNode = node.next;

        preNode.next = nextNode;
        nextNode.pre = preNode;

        node.pre = null;
        node.next = null;

        this.cache.remove(node.k);

        this.size--;
    }
}
