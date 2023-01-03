package lc1672;

import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public int maximumWealth(int[][] accounts) {
        return Stream.of(accounts)
                .map(account -> IntStream.of(account).reduce(Integer::sum))
                .max(Comparator.comparingInt(o -> o.orElse(0)))
                .orElse(OptionalInt.of(0)).orElse(0);
    }
}
