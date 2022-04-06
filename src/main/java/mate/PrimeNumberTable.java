package mate;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumberTable {
    private static Set<Long> set = new HashSet<>();

    static {
        set.add(2L);
        set.add(3L);
        set.add(5L);
        set.add(7L);
        set.add(11L);
        set.add(13L);
        set.add(17L);
        set.add(19L);
        set.add(23L);
        set.add(29L);
        set.add(31L);
        set.add(37L);
        set.add(41L);
        set.add(43L);
        set.add(47L);
        set.add(53L);
        set.add(59L);
        set.add(61L);
        set.add(67L);
        set.add(71L);
        set.add(73L);
        set.add(79L);
        set.add(83L);
        set.add(89L);
        set.add(97L);
    }

    public static boolean check(long n) {
        return set.contains(n);
    }
}
