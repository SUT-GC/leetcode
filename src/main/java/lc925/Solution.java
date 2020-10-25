package lc925;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null) {
            return false;
        }
        if (Objects.equals(name, typed)) {
            return true;
        }

        int i = 0;
        int j = 0;
        Character c = null;
        while (i <= name.length() && j <= typed.length()) {
            if (i == name.length() && j == typed.length()) {
                return true;
            } else if (i == name.length() && j < typed.length()) {
                i--;
            } else if (i != name.length() && j == typed.length()) {
                return false;
            }

            Character nc = name.charAt(i);
            Character yc = typed.charAt(j);

            if (yc.equals(nc)) {
                i++;
                j++;
                c = yc;
                continue;
            }

            if (yc.equals(c)) {
                j++;
                continue;
            }

            return false;
        }

        return false;
    }


}
