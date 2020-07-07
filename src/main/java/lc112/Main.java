package lc112;

import mate.TreeNode;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode() {{
            setVal(5);
            setLeft(new TreeNode() {{
                setVal(4);
                setLeft(new TreeNode() {{
                    setVal(11);
                    setLeft(new TreeNode() {{
                        setVal(7);
                    }});
                    setRight(new TreeNode() {{
                        setVal(1);
                    }});
                }});
            }});
            setRight(new TreeNode() {{
                setVal(8);
                setLeft(new TreeNode() {{
                    setVal(13);
                }});
                setRight(new TreeNode() {{
                    setVal(4);
                    setRight(new TreeNode() {{
                        setVal(1);
                    }});
                }});
            }});
        }};

        System.out.println(solution.hasPathSum(treeNode, 22));
    }

}
