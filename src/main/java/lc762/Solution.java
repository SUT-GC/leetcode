package lc762;

import java.util.stream.IntStream;
import mate.PrimeNumberTable;

public class Solution {
    public int countPrimeSetBits(int left, int right) {
        return (int) IntStream.range(left, right + 1).boxed()
                .map(Integer::toBinaryString)
                .map(s -> s.chars().filter(c -> c == '1').count())
                .filter(PrimeNumberTable::check).count();
    }
}
