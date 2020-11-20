package lc147;

import mate.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (null == head) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
            if (null == newHead) {
                newHead = new ListNode(head.val);
            } else {
                ListNode temp = newHead;
                while (temp != null) {
                    if (newHead.val >= head.val) {
                        ListNode i = new ListNode(head.val);
                        newHead = i;
                        i.next = temp;
                        break;
                    } else if (temp.val < head.val && temp.next == null) {
                        temp.next = new ListNode(head.val);
                        break;
                    } else if (temp.val <= head.val && temp.next.val >= head.val) {
                        ListNode i = new ListNode(head.val);
                        i.next = temp.next;
                        temp.next = i;
                        break;
                    }
                    temp = temp.next;
                }
            }

            head = head.next;
        }

        return newHead;
    }
}
