package lc328;

import java.util.Optional;
import mate.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        // NULL || 1->NULL || 1->2->NULL
        if (null == head || null == head.next || null == head.next.next) {
            return head;
        }


        ListNode n = head;
        ListNode p = n.next;
        ListNode e = p.next;

        while (e != null) {

            ListNode nextP = e.next;
            ListNode nextE = nextP == null ? null : nextP.next;

            p.next = e.next;
            e.next = n.next;
            n.next = e;

            n = n.next;
            e = nextE;
            p = nextP;
        }

        return head;
    }
}
