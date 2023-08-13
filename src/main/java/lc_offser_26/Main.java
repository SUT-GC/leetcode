package lc_offser_26;

import mate.ListNode;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solution.reorderList(head);

        System.out.println(head);
    }
}
