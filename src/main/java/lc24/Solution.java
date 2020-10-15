package lc24;

import mate.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;

        ListNode pre = null;
        ListNode mid = head;
        ListNode lat = head.next;

        while (true) {
            pre = swap(pre, mid, lat);
            mid = pre.next;
            if (mid == null) {
                break;
            }
            lat = mid.next;
            if (lat == null) {
                break;
            }
        }

        return newHead;
    }

    private ListNode swap(ListNode pre, ListNode mid, ListNode lat) {
        mid.next = lat.next;
        lat.next = mid;

        if (null != pre) {
            pre.next = lat;
        }

        return mid;
    }

}
