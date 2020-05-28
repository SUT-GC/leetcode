package lc445;

import mate.ListNode;

import java.math.BigInteger;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = covertToNum(l1);
        BigInteger num2 = covertToNum(l2);

        BigInteger sum = num1.add(num2);

        return covertToList(sum);
    }

    private ListNode covertToList(BigInteger sum) {
        ListNode head = new ListNode(-1);

        while (sum.compareTo(new BigInteger("0")) > 0) {
            BigInteger mod = sum.mod(new BigInteger("10"));
            ListNode node = new ListNode(mod.intValue());
            node.next = head.next;
            head.next = node;

            sum = sum.divide(new BigInteger("10"));
        }

        return head.next;
    }

    private BigInteger covertToNum(ListNode l1) {
        BigInteger r = new BigInteger("0");
        ListNode now = l1;
        while (now != null) {
            r = r.multiply(new BigInteger("")).add(new BigInteger(l1.val + ""));
            now = now.next;
        }

        return r;
    }
}
