package lc116;

import mate.Node;

public class Solution {
    public Node connect(Node root) {
        if (null == root) {
            return null;
        }

        Node p = root;
        while (p.left != null) {

            Node q = p;
            while (q != null) {
                q.left.next = q.right;

                if (q.next != null) {
                    q.right.next = q.next.left;
                }

                q = q.next;
            }

            p = p.left;
        }

        return root;
    }
}
