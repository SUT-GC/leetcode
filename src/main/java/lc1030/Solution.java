package lc1030;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    class Part {
        public int x;
        public int y;

        public Part(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        if (R < 0 || C < 0 || r0 < 0 || c0 < 0 || r0 >= R || c0 >= C || (R == 0 && C == 0)) {
            return new int[0][0];
        }

        // init
        List<Part> parts = init(R, C);

        // sort
        sort(parts, r0, c0);

        // convert
        return convertToArrays(parts);
    }

    private int[][] convertToArrays(List<Part> parts) {
        int[][] r = new int[parts.size()][2];
        int i = 0;

        for (Part part : parts) {
            r[i][0] = part.x;
            r[i][1] = part.y;
            i++;
        }

        return r;
    }

    private void sort(List<Part> parts, int x, int y) {
        parts.sort((o1, o2) -> {
            // |r1 - r2| + |c1 - c2|
            int o1l = Math.abs(o1.x - x) + Math.abs(o1.y - y);
            int o2l = Math.abs(o2.x - x) + Math.abs(o2.y - y);

            return Integer.compare(o1l, o2l);
        });
    }

    private List<Part> init(int r, int c) {
        List<Part> ans = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans.add(new Part(i, j));
            }
        }

        return ans;
    }
}
