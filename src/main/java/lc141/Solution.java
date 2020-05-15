package lc141;

import mate.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode a = head;
        ListNode b = head;

        a = a;
        b = b.next;

        while (a != b && a != null && b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
        }

        return a == b;
    }
}
