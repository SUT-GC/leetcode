package lc661;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] result = new int[img.length][img[0].length];

        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                result[i][j] = avg(img, i, j);
            }
        }

        return result;
    }

    private int avg(int[][] img, int i, int j) {
        Stream<Integer> stream = Stream.of(
                getValue(img, i - 1, j - 1),
                getValue(img, i, j - 1),
                getValue(img, i + 1, j - 1),
                getValue(img, i - 1, j),
                getValue(img, i, j),
                getValue(img, i + 1, j),
                getValue(img, i - 1, j + 1),
                getValue(img, i, j + 1),
                getValue(img, i + 1, j + 1)
        );

        AtomicInteger count = new AtomicInteger(0);
        long sum = stream.parallel().filter(Objects::nonNull).peek(p -> count.incrementAndGet()).reduce(Integer::sum).orElse(0);

        return (int) (sum / count.get());
    }

    private Integer getValue(int[][] img, int i, int j) {
        if (i < 0 || j < 0) {
            return null;
        }
        if (i >= img.length || j >= img[0].length) {
            return null;
        }

        return img[i][j];
    }
}