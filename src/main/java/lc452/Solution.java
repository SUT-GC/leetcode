package lc452;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    class Part {
        int start;
        int end;

        public Part(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Part(int[] points) {
            this(points[0], points[1]);
        }

        public Part() {
        }

        public int[] toArrays() {
            return new int[]{this.start, this.end};
        }
    }

    public int findMinArrowShots(int[][] points) {
        // conner case
        if (null == points || points.length == 0) {
            return 0;
        }

        // covert to parts
        List<Part> parts = convert(points);

        // sort
        sort(parts);

        // merge conflict
        parts = merge(parts);

        return parts.size();
    }

    private List<Part> merge(List<Part> parts) {
        List<Part> result = new ArrayList<>();

        Part newP = null;
        for (Part oldP : parts) {
            if (newP == null) {
                newP = new Part(oldP.start, oldP.end);
                continue;
            }

            if (oldP.start >= newP.start && oldP.start <= newP.end) {
                newP.end = Math.min(newP.end, oldP.end);
            } else {
                result.add(newP);
                newP = new Part(oldP.start, oldP.end);
            }
        }
        result.add(newP);

        return result;
    }

    private void sort(List<Part> parts) {
        parts.sort(Comparator.comparingInt((Part o) -> o.start).thenComparingInt(o -> o.end));
    }

    private List<Part> convert(int[][] points) {
        List<Part> parts = new ArrayList<>();

        for (int[] point : points) {
            parts.add(new Part(point));
        }

        return parts;
    }
}
