package lc821;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                indexes.add(i);
            }
        }

        int[] result = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int min = Integer.MAX_VALUE;

            for (Integer index : indexes) {
                if (Math.abs(i - index) < min) {
                    min = Math.abs(i - index);
                }
            }

            result[i] = min;
        }

        return result;
    }
}
