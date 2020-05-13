package lc155;

import java.util.ArrayList;
import java.util.LinkedList;

public class MinStack {
    public static class Node {
        int value;
        int minValue;
    }

    LinkedList<Node> stack = null;
    int size = 0;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<>();
        size = 0;
    }

    public void push(int x) {
        if (this.stack.isEmpty()) {
            Node node = new Node();
            node.value = x;
            node.minValue = node.value;
            this.stack.addLast(node);
        } else {
            Node lastNode = stack.getLast();
            Node newNode = new Node();
            newNode.value = x;
            newNode.minValue = Math.min(newNode.value, lastNode.minValue);
            this.stack.addLast(newNode);
        }
    }

    public void pop() {
        if (this.stack.isEmpty()) {
            return;
        }

        this.stack.removeLast();
    }

    public int top() {
        if (this.stack.isEmpty()) {
            return 0;
        }

        return this.stack.getLast().value;
    }

    public int getMin() {
        if (this.stack.isEmpty()) {
            return 0;
        }

        return this.stack.getLast().minValue;
    }
}
