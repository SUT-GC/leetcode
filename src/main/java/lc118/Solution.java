package lc118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();

        ans.add(new ArrayList<Integer>() {{
            add(1);
        }});

        for (int i = 1; i < numRows; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < 1 + i; j++) {
                if (j - 1 < 0) {
                    ans.get(i).add(ans.get(i - 1).get(j));
                    continue;
                }

                if (j >= ans.get(i - 1).size()) {
                    ans.get(i).add(ans.get(i - 1).get(j - 1));
                    continue;
                }

                ans.get(i).add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
        }

        return ans;
    }
}
