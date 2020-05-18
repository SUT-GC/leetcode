package lc206;

import mate.ListNode;

public class Solution {
    private ListNode result = null;

    public ListNode reverseList(ListNode head) {
        doRevers(head);
        return result;
    }

    public ListNode doRevers(ListNode head) {
        if (head == null || head.next == null) {
            result = head;
            return head;
        }

        ListNode reversHead = doRevers(head.next);
        reversHead.next = head;
        head.next = null;

        return head;
    }
}
