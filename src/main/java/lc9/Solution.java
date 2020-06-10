package lc9;

public class Solution {
    public boolean isPalindrome2(int x) {
        String s = String.valueOf(x);
        int len = s.length();

        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        return s.equals(new StringBuffer(s).reverse().toString());
    }
}
