package lc147;

import mate.ListNode;

public class Main {
    public static void main(String[] args) {
        ListNode list = new ListNode(4);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(1);
        list.next.next.next.next = new ListNode(5);

        ListNode temp = new Solution().insertionSortList(list);
        System.out.println(temp);
    }
}
