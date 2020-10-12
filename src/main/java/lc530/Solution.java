package lc530;

import java.util.ArrayList;
import java.util.List;
import mate.TreeNode;

public class Solution {

    public List<Integer> sort = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {

        mid(root);

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < sort.size(); i++) {
            ans = Math.min(ans, Math.abs(sort.get(i) - sort.get(i - 1)));
        }

        return ans;
    }

    public void mid(TreeNode root) {
        if (null == root) {
            return;
        }

        mid(root.left);
        sort.add(root.val);
        mid(root.right);
    }
}
