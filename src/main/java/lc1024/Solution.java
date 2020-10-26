package lc1024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Solution {
    class Part {
        public int start;
        public int end;

        public Part(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int videoStitching(int[][] clips, int T) {
        if (null == clips || clips.length == 0 || T <= 0) {
            return -1;
        }

        List<Part> parts = new ArrayList<>();
        for (int[] clip : clips) {
            parts.add(new Part(clip[0], clip[1]));
        }

        Map<Integer, List<Part>> startMapParts;
        startMapParts = parts.stream().collect(Collectors.groupingBy(part -> part.start));
        startMapParts.forEach((k, v) -> {
            v.sort((o1, o2) -> {
                int o1l = o1.end - o1.start;
                int o2l = o2.end - o2.start;

                return Integer.compare(o2l, o1l);
            });
        });

        int count = 0;
        int end = 0;
        List<Part> tempParts;

        while (end < T) {
            boolean out = true;
            int tempEnd = end;
            for (int i = 0; i <= tempEnd; i++) {
                tempParts = startMapParts.getOrDefault(i, new ArrayList<>());
                if (tempParts.isEmpty()) {
                    continue;
                }

                int newEnd = tempParts.get(0).end;
                if (out && newEnd > end) {
                    count++;
                    out = false;
                }
                end = Math.max(newEnd, end);
            }

            if (out) {
                return -1;
            }
        }

        return count <= 0 ? -1 : count;
    }
}
