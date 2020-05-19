package lc125;

public class Solution {
    public boolean isPalindrome(String s) {
        int[] sArray = s.toLowerCase().chars().parallel().filter(p -> (p >= 48 && p <= 57) || (p >= 97 && p <= 122)).toArray();

        return check(sArray);
    }

    public boolean check(int[] s) {
        for (int i = 0, j = s.length - 1; i < j; ) {
            if (s[i] == s[j]) {
                i++;
                j--;
            } else {

                return false;
            }
        }

        return true;
    }
}