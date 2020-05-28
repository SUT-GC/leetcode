package lc141;

import mate.ListNode;

public class Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
//        node2.setNext(node3);
//        node3.setNext(node4);
//        node4.setNext(node2);

        Solution solution = new Solution();
        System.out.println(solution.hasCycle(node1));

    }
}
