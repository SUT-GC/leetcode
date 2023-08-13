package lc109;

import mate.ListNode;
import mate.TreeNode;

class Solution {
    public static class MidList {
        public ListNode mid;
        public ListNode left;
        public ListNode right;

        public MidList(ListNode mid, ListNode left, ListNode right) {
            this.mid = mid;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (null == head) {
            return null;
        }
        MidList midList = findMidList(head);
        TreeNode root = new TreeNode();
        root.val = midList.mid.val;
        root.left = sortedListToBST(midList.left);
        root.right = sortedListToBST(midList.right);

        return root;
    }

    private MidList findMidList(ListNode head) {
        int len = 0;
        ListNode now = head;
        while (now != null) {
            len++;
            now = now.next;
        }
        if (len <= 1) {
            return new MidList(head, null, null);
        }

        ListNode mid = head;
        len = len / 2 - 1;
        while (len > 0) {
            mid = mid.next;
            len--;
        }

        MidList midList = new MidList(mid.next, head, mid.next.next);
        mid.next.next = null;
        mid.next = null;

        return midList;
    }
}