package lc406;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    class Part {
        int start;
        int end;

        public Part(int[] intervals) {
            this.start = intervals[0];
            this.end = intervals[1];
        }

    }

    static int[][] convertToArrays(List<Part> parts) {
        int[][] r = new int[parts.size()][2];
        int i = 0;

        for (Part part : parts) {
            r[i][0] = part.start;
            r[i][1] = part.end;
            i++;
        }

        return r;
    }

    public List<Part> convertToParts(int[][] intervals) {
        List<Part> parts = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            parts.add(new Part(intervals[i]));
        }

        return parts;
    }


    public int[][] reconstructQueue(int[][] people) {
        if (null == people || people.length == 0) {
            return people;
        }

        // convert
        List<Part> parts = convertToParts(people);

        // sort first end second start
        sort(parts);

        // init ans
        List<Part> ans = new LinkedList<>();

        // resort
        resort(ans, parts);

        // return
        return convertToArrays(ans);
    }

    private void resort(List<Part> ans, List<Part> parts) {
        for (Part insert : parts) {
            int count = 0;
            boolean inserted = false;
            for (int i = 0; i < ans.size(); i++) {
                Part now = ans.get(i);
                // 前面没有 >= insert.start 的
                if (insert.end == 0 || insert.end == count) {
                    if (now.start >= insert.start) {
                        ans.add(i, insert);
                        inserted = true;
                        break;
                    }
                }

                if (insert.start <= now.start) {
                    count++;
                }
            }

            if (!inserted) {
                ans.add(insert);
            }
        }
    }

    private void sort(List<Part> parts) {
        parts.sort((o1, o2) -> {
            if (o1.end < o2.end) {
                return -1;
            }
            if (o1.end > o2.end) {
                return 1;
            }
            if (o1.start < o2.start) {
                return -1;
            }
            if (o1.start > o2.start) {
                return 1;
            }

            return 0;
        });
    }
}
