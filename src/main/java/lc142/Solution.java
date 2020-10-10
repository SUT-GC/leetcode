package lc142;

import java.util.HashSet;
import java.util.Set;
import mate.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) {
                return head;
            }

            nodes.add(head);
            head = head.next;
        }

        return null;
    }
}
