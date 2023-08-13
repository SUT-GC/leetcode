package lc_offser_0208;

import mate.ListNode;

public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        Solution solution = new Solution();
        ListNode listNode = solution.detectCycle(n1);

        System.out.println(listNode);
    }
}
