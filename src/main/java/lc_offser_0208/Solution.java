package lc_offser_0208;

import mate.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }

        // 找环
        ListNode fast = head;
        ListNode slow = head;

        do {
            if (null == fast.next || null == fast.next.next) {
                return null;
            }

            fast = fast.next.next;
            slow = slow.next;

        } while (fast != slow);

        // fast 复位，然后变慢，碰撞slow
        fast = head;
        int index = 0;
        while (true) {
            if (fast == slow) {
                return slow;
            }

            fast = fast.next;
            slow = slow.next;
            index++;
        }
    }
}
