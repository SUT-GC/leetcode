package lc57;

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

        public Part() {
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // conner case
        if (null == newInterval || newInterval.length <= 0) {
            return intervals;
        }
        if (null == intervals || intervals.length <= 0) {
            return new int[][]{newInterval};
        }

        // convert input to class Part Object
        List<Part> parts = convertToParts(intervals);
        Part newPart = convertToPart(newInterval);

        // insert new Part to Parts
        boolean op = insertStartPoint(parts, newPart);
        if (!op) {
            op = insertEndPoint(parts, newPart);
        }
        if (!op) {
            parts.add(newPart);
        }

        // merge conflict part
        parts = merge(parts);

        // convert parts to int[][] Object
        return convertToArrays(parts);
    }

    private int[][] convertToArrays(List<Part> parts) {
        int[][] r = new int[parts.size()][2];
        int i = 0;

        for (Part part : parts) {
            r[i][0] = part.start;
            r[i][1] = part.end;
            i++;
        }

        return r;
    }

    private List<Part> merge(List<Part> parts) {
        parts.sort(Comparator.comparingInt(o -> o.start));

        List<Part> merged = new ArrayList<>();
        for (int i = 0; i < parts.size(); i++) {
            Part target = new Part(parts.get(i).start, parts.get(i).end);
            for (int j = i + 1; j < parts.size(); j++) {
                Part now = parts.get(j);
                if (target.start <= now.start && target.end >= now.start) {
                    target.end = Math.max(now.end, target.end);
                    i++;
                }
            }
            merged.add(target);
        }

        return merged;
    }

    private boolean insertEndPoint(List<Part> parts, Part newPart) {
        for (Part part : parts) {
            if (part.start <= newPart.end && part.end >= newPart.end) {
                part.start = Math.min(newPart.start, part.start);
                return true;
            }
        }

        return false;
    }

    private boolean insertStartPoint(List<Part> parts, Part newPart) {
        for (Part part : parts) {
            if (part.start <= newPart.start && part.end >= newPart.start) {
                part.end = Math.max(newPart.end, part.end);
                return true;
            }
        }

        return false;
    }

    private Part convertToPart(int[] intervals) {

        return new Part(intervals[0], intervals[1]);
    }

    private List<Part> convertToParts(int[][] intervals) {
        List<Part> parts = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            parts.add(new Part(intervals[i][0], intervals[i][1]));
        }

        return parts;
    }
}
