package lc61;

import java.util.LinkedList;
import mate.ListNode;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head) {
            return head;
        }

        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            stack.addLast(temp);
            temp = temp.next;
            len++;
        }

        k = k % len;
        if (k <= 0) {
            return head;
        }

        ListNode popListHead = null;
        ListNode popListTail = stack.getLast();
        while (k > 0 && !stack.isEmpty()) {
            popListHead = stack.removeLast();
            k--;
        }

        stack.getLast().next = null;
        popListTail.next = head;

        return popListHead;
    }
}