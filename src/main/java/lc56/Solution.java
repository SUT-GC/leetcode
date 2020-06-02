package lc56;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static class Pair {
        public int start;
        public int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            pairs.add(new Pair(intervals[i][0], intervals[i][1]));
        }

        pairs.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.start > o2.start) {
                    return 1;
                }
                if (o1.start == o2.start) {
                    return Integer.compare(o1.end, o2.end);
                }
                return -1;
            }
        });

        List<Pair> ans = new ArrayList<>();
        Pair now = null;
        for (Pair pair : pairs) {
            if (now == null) {
                now = pair;
                continue;
            }

            if (pair.start <= now.end) {
                now.end = Math.max(now.end, pair.end);
                continue;
            }

            ans.add(now);
            now = pair;
        }
        ans.add(now);

        int[][] a = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            a[i][0] = ans.get(i).start;
            a[i][1] = ans.get(i).end;
        }

        return a;
    }
}
