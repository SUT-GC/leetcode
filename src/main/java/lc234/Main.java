package lc234;

import mate.ListNode;

public class Main {
    public static void main(String[] args) {
        ListNode list = new ListNode(1) {{
            next = new ListNode(2) {{
                next = new ListNode(3) {{
                    next = new ListNode(4) {{
                        next = new ListNode(5);
                    }};
                }};
            }};
        }};
        new Solution().isPalindrome(list);
    }
}
