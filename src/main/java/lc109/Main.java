package lc109;

import mate.ListNode;
import mate.TreeNode;

public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution solution = new Solution();

        TreeNode treeNode = solution.sortedListToBST(listNode);
        System.out.println(treeNode);
    }
}
