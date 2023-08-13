package lc_offser_077;

import mate.ListNode;

public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode l2 = new ListNode(2, new ListNode(3, new ListNode(4)));

        Solution solution = new Solution();
        ListNode merged = solution.merge(l1, l2);

        System.out.println(merged);

        ListNode l = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode sortList = solution.sortList(l);

        System.out.println(sortList);
    }
}
