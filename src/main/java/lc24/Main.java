package lc24;

import mate.ListNode;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1) {{
//            next = new ListNode(2) {{
//                next = new ListNode(3) {{
//                    next = new ListNode(4);
//                }};
//            }};
        }};

        System.out.println(new Solution().swapPairs(head));
    }
}
