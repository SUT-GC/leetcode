package lc968;

import mate.TreeNode;

/**
 * 状态0：节点没有被监控
 * 状态1：节点被监控了但是节点上并没有摄像头
 * 状态2：节点被监控了同时节点上安装了摄像头
 */
class Solution {
    private int ans;

    public int minCameraCover(TreeNode root) {
        int v = cal(root);

        return v == 0 ? ans + 1 : ans;
    }

    private int cal(TreeNode root) {
        if (root == null) {
            return 1;
        }

        int left = cal(root.left);
        int right = cal(root.right);

        // 如果左节点没有被监控 或者 右节点没有被监控
        // 那么当前节点一定要安装摄像头，覆盖左和右
        if (left == 0 || right == 0) {
            ans++;
            return 2;
        }

        // 如果左节点和右节点都被监控了，且没有摄像头
        // 当前节点一定是不安摄像头最好
        if (left == 1 && right == 1) {
            return 0;
        }

        // 如果左节点或者右节点被监控了且有一个有摄像头
        // 则当前节点一定是被监控了且没有摄像头
        return 1;
    }
}
