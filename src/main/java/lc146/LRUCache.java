package lc146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static class Node {
        public int k;
        public int v;
        public Node pre;
        public Node next;

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    public int capacity;
    public int size;
    public Map<Integer, Node> dict;
    public Node head;
    public Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.dict = new HashMap<>();
        this.head = new Node(-1000, -1000);
        this.tail = new Node(-1001, -1001);
    }

    public int get(int key) {
        Node node = dict.get(key);
        if (node == null) {
            // 如果cache中不存在，返回-1
            return -1;
        } else {
            // 否则将node从原来位置删除，并且插入到链表头
            this.delete(node);
            this.insert(node);
            return node.v;
        }
    }


    public void put(int key, int value) {
        Node node = dict.get(key);

        if (node == null) {
            node = new Node(key, value);
            // 如果该节点不在cache中
            // 将这个节点插入到cache中
            this.insert(node);
        } else {
            // 如果节点在cache中
            node.v = value;
            // 将这个节点从原来位置删除，并且插入到cache中
            this.delete(node);
            this.insert(node);
        }
    }

    private void insert(Node node) {
        if (this.capacity == this.size) {
            this.delete(this.tail.pre);
        }

        if (this.head.next == null) {
            this.head.next = node;
            node.pre = this.head;
            this.tail.pre = node;
            node.next = this.tail;
        } else {
            node.next = this.head.next;
            this.head.next.pre = node;
            this.head.next = node;
            node.pre = this.head;
        }

        this.size++;

        this.dict.put(node.k, node);
    }

    private void delete(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        this.size--;

        this.dict.remove(node.k);
    }
}
