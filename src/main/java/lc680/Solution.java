package lc680;

public class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return check(s.substring(i, j)) || check(s.substring(i + 1, j + 1));
            }
        }

        return true;
    }

    public boolean check(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {

                return false;
            }
        }

        return true;
    }
}
