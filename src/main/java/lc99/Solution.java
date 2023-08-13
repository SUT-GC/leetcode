package lc99;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import mate.TreeNode;

class Solution {
    public void recoverTree(TreeNode root) {
        if (null == root) {
            return;
        }

        List<TreeNode> midShowList = midShow(root);
        List<TreeNode> sortList = midShowList.stream().sorted(Comparator.comparingInt(o -> o.val)).collect(Collectors.toList());

        TreeNode errorNode1 = null;
        TreeNode errorNode2 = null;

        for (int i = 0; i < midShowList.size(); i++) {
            if (midShowList.get(i).val != sortList.get(i).val) {
                if (null == errorNode1) {
                    errorNode1 = midShowList.get(i);
                } else {
                    errorNode2 = midShowList.get(i);
                }
            }
        }

        if (null != errorNode1 && null != errorNode2) {
            int temp = errorNode1.val;
            errorNode1.val = errorNode2.val;
            errorNode2.val = temp;
        }
    }

    public List<TreeNode> midShow(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();

        if (null == root) {
            return result;
        }

        result.addAll(midShow(root.left));
        result.add(root);
        result.addAll(midShow(root.right));

        return result;
    }
}