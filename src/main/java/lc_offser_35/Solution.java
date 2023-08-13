package lc_offser_35;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node, Node> oldMapNew = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }

        if (oldMapNew.containsKey(head)) {
            return oldMapNew.get(head);
        }

        Node newNode = new Node(head.val);
        oldMapNew.put(head, newNode);

        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);

        return newNode;
    }
}
