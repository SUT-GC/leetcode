package lc937;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    class Pair {
        int x;
        int y;
        int distinct;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;

            this.distinct = x * x + y * y;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        if (null == points || points.length <= 0) {
            return points;
        }

        List<Pair> pairs = convertToPair(points);

        pairs.sort(Comparator.comparingInt(o -> o.distinct));

        return convertAndSplit(pairs, K);
    }

    private int[][] convertAndSplit(List<Pair> pairs, int k) {
        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i][0] = pairs.get(i).x;
            result[i][1] = pairs.get(i).y;
        }

        return result;
    }

    private List<Pair> convertToPair(int[][] points) {
        List<Pair> pairs = new ArrayList<>();

        for (int[] point : points) {
            pairs.add(new Pair(point[0], point[1]));
        }

        return pairs;
    }
}
