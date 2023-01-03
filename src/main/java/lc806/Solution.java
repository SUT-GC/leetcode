package lc806;

public class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int line = 1;
        int nowLineCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            if (nowLineCount + widths[index] <= 100) {
                nowLineCount += widths[index];
            } else {
                line++;
                nowLineCount = widths[index];
            }
        }

        return new int[]{line, nowLineCount};
    }
}
