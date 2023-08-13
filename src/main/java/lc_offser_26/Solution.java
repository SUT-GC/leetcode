package lc_offser_26;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import mate.ListNode;
import mate.Node;

public class Solution {
    public void reorderList(ListNode head) {
        if (null == head) {
            return;
        }

        LinkedList<ListNode> queue = new LinkedList<>();
        LinkedList<ListNode> stack = new LinkedList<>();

        ListNode cur = head;
        while (cur != null) {
            queue.addLast(cur);
            stack.addLast(cur);
            cur = cur.next;
        }

        if (queue.size() <= 1) {
            return;
        }

        ListNode newDummy = new ListNode(0);
        Set<ListNode> dup = new HashSet<>();

        cur = newDummy;
        while (true) {
            ListNode qf = queue.removeFirst();
            ListNode sl = stack.removeLast();

            if (dup.contains(qf) && dup.contains(sl)) {
                break;
            }

            if (!dup.contains(qf)) {
                dup.add(qf);
                cur.next = qf;
                cur = cur.next;
            }
            if (!dup.contains(sl)) {
                dup.add(sl);
                cur.next = sl;
                cur = cur.next;
            }

            cur.next = null;
        }

        head = newDummy.next;
    }
}
