package lc728;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        return IntStream.range(left, right + 1).boxed()
                .filter(num -> !String.valueOf(num).contains("0"))
                .filter(num -> String.valueOf(num).chars().allMatch(c -> num % (c - 48) == 0))
                .collect(Collectors.toList());
    }
}
