package lc1370;

public class Solution {
    public String sortString(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            char line = Character.MIN_VALUE;
            while (true) {
                int index = findLastC(s, true, line);
                if (index < 0) {
                    break;
                } else {
                    line = s.charAt(index);
                    s = removeI(s, index);
                    result.append(line);
                }
            }
            line = Character.MAX_VALUE;
            while (true) {
                int index = findLastC(s, false, line);
                if (index < 0) {
                    break;
                } else {
                    line = s.charAt(index);
                    s = removeI(s, index);
                    result.append(line);
                }
            }
        }

        return result.toString();
    }

    public int findLastC(String s, boolean min, char line) {
        int index = -1;
        char lastC = min ? Character.MAX_VALUE : Character.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (min) {
                if (s.charAt(i) < lastC && s.charAt(i) > line) {
                    lastC = s.charAt(i);
                    index = i;
                }
            } else {
                if (s.charAt(i) > lastC && s.charAt(i) < line) {
                    lastC = s.charAt(i);
                    index = i;
                }
            }
        }

        return index;
    }

    public String removeI(String s, int i) {
        if (i >= s.length()) {
            return s;
        }

        if (i == 0) {
            if (s.length() == 0) {
                return s;
            }
            if (s.length() == 1) {
                return "";
            }
            if (s.length() > 1) {
                return s.substring(i + 1);
            }
        }

        if (i == s.length() - 1) {
            if (s.length() == 0) {
                return s;
            }
            if (s.length() == 1) {
                return "";
            }
            if (s.length() > 1) {
                return s.substring(0, i);
            }
        }

        return s.substring(0, i) + s.substring(i + 1);
    }
}
