package lc19;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mate.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head || n < 1) {
            return head;
        }

        List<ListNode> list = new ArrayList<>();

        ListNode now = head;
        while (null != now) {
            list.add(now);
            now = now.next;
        }


        int deleteIndex = list.size() - n;
        ListNode deleteNode = list.get(deleteIndex);

        // 说明是删除的头节点
        if (deleteIndex == 0) {
            head = deleteNode.next;
        } else {
            ListNode parentNode = list.get(deleteIndex - 1);
            parentNode.next = parentNode.next.next;
        }

        return head;
    }
}