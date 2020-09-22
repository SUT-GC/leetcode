package lc968;

import mate.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode() {{
            setVal(0);
            setLeft(new TreeNode() {{
                setVal(0);
                setLeft(new TreeNode() {{
                    setVal(0);
                    setRight(new TreeNode() {{
                        setVal(0);
                        setLeft(null);
                        setRight(new TreeNode() {{
                            setVal(0);
                            setLeft(null);
                            setRight(null);
                        }});
                    }});
                    setLeft(null);
                }});
            }});
            setRight(null);
        }};

        int r = new Solution().minCameraCover(treeNode);
        System.out.println(r);
    }
}
