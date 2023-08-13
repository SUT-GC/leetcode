package lc_offser_077;

import mate.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode mid = head;
        ListNode tail = head;

        // 找中点
        while (tail.next != null && tail.next.next != null) {
            mid = mid.next;
            tail = tail.next.next;
        }

        // 分成两个链表
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;

        l1 = sortList(l1);
        l2 = sortList(l2);

        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }

        if (null == l2) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode curL1 = l1;
        ListNode curL2 = l2;
        ListNode curNew = dummy;

        while (curL2 != null && curL1 != null) {
            if (curL1.val <= curL2.val) {
                curNew.next = curL1;
                curL1 = curL1.next;
                curNew = curNew.next;
            } else {
                curNew.next = curL2;
                curL2 = curL2.next;
                curNew = curNew.next;
            }
        }

        if (curL2 == null) {
            curNew.next = curL1;
        }
        if (curL1 == null) {
            curNew.next = curL2;
        }

        return dummy.next;
    }
}
