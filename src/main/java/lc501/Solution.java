package lc501;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import mate.TreeNode;

public class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> count = new HashMap<>();
        morris(root, count);

        int maxC = -1;
        for (Integer key : count.keySet()) {
            maxC = Math.max(maxC, count.get(key));
        }

        List<Integer> rl = new LinkedList<>();
        for (Integer key : count.keySet()) {
            if (count.get(key) == maxC) {
                rl.add(key);
            }
        }

        int[] ans = new int[rl.size()];
        for (int i = 0; i < rl.size(); i++) {
            ans[i] = rl.get(i);
        }

        return ans;
    }

    public void morris(TreeNode root, Map<Integer, Integer> count) {
        if (null == root) {
            return;
        }

        morris(root.right, count);
        count.compute(root.val, (k, v) -> {
            if (v == null) return v = 1;
            else return v += 1;
        });
        morris(root.left, count);
    }
}
