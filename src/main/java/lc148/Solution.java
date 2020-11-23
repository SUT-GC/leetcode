package lc148;

import mate.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode ans = sortList(head, null);

        return ans;
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }

        if (head == tail) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode one = sortList(head, mid);
        ListNode two = sortList(mid, tail);

        ListNode merged = merge(one, two);

        return merged;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        ListNode one = head1;
        ListNode two = head2;

        while (one != null && two != null) {
            if (one.val >= two.val) {
                temp.next = two;
                temp = temp.next;
                two = two.next;
            } else {
                temp.next = one;
                temp = temp.next;
                one = one.next;
            }
        }

        if (one != null) {
            temp.next = one;
        }
        if (two != null) {
            temp.next = two;
        }

        return head.next;
    }
}
