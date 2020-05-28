package lc445;

import mate.ListNode;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode x1 = new ListNode(1);
        ListNode x2 = new ListNode(8);
        x1.next = x2;

        ListNode y1 = new ListNode(1);
        ListNode y2 = new ListNode(7);
        y1.next = y2;

        ListNode r = solution.addTwoNumbers(x1, y1);
        System.out.println(r);
    }
}
