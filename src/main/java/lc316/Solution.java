package lc316;

import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        // 初始化最后字符最后出现的index
        for (int i = 0; i < len; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }

        for (int i = 0; i < len; i++) {
            // 已经存进去的，就pass
            if (visited[chars[i] - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > chars[i] && i < lastIndex[stack.peek() - 'a']) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }

            stack.push(chars[i]);
            visited[chars[i] - 'a'] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : stack) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }
}
