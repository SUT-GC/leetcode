package lc796;

import java.util.stream.IntStream;

public class Solution {
    public boolean rotateString(String s, String goal) {
        return IntStream.range(0, s.length())
                .anyMatch(i -> goal.equals(s.substring(i) + s.substring(0, i)));
    }
}