package lc744;

import java.util.TreeSet;

public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        TreeSet<Integer> set = new TreeSet<>();

        for (char letter : letters) {
            set.add((int) letter);
        }

        Integer ceiling = set.ceiling((int) target + 1);
        if (null == ceiling) {
            ceiling = set.ceiling(0);
        }

        return (char) ceiling.intValue();
    }
}
