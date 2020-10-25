package lc234;

import mate.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        // 找出列表长度
        int c = 0;
        ListNode tempNode = head;
        while (tempNode != null) {
            c++;
            tempNode = tempNode.next;
        }

        // 找出要反转的链表
        int mid = c / 2;
        ListNode midNode = head;
        ListNode preNode = head;
        while (mid > 0) {
            preNode = midNode;
            midNode = midNode.next;
            mid--;
        }

        // 反转链表
//        reverse(midNode);
        ListNode nextNode = midNode.next;
        while (null != nextNode) {
            nextNode = nextNode.next;
            midNode.next.next = midNode;
            midNode.next = preNode;
            preNode = midNode;
        }

        System.out.println(head);
        System.out.println(midNode);

        return false;
    }
}
