package lc31;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 2};

        new Solution().nextPermutation(input);

        System.out.println(Arrays.toString(input));
    }
}
