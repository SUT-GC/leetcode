package lc844;

import java.util.Enumeration;
import java.util.Stack;

public class Solution {
    public boolean backspaceCompare(String S, String T) {
        S = format(S);
        T = format(T);

        return S.equals(T);
    }

    public String format(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        StringBuffer result = new StringBuffer();

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
