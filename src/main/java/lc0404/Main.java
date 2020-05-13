package lc0404;

import mate.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode() {{
            setVal(3);
            ;
            setLeft(new TreeNode() {{
                setVal(9);
            }});
            setRight(new TreeNode() {{
                setVal(20);
                setLeft(new TreeNode() {{
                    setVal(15);
                }});
                setRight(new TreeNode() {{
                    setVal(7);
                }});
            }});
        }};

        TreeNode treeNode2 = new TreeNode() {{
            setVal(1);
            setLeft(new TreeNode() {{
                setVal(2);
                setLeft(new TreeNode() {{
                    setVal(3);
                    setLeft(new TreeNode() {{
                        setVal(3);
                        setLeft(new TreeNode() {{
                            setVal(4);
                        }});
                        setRight(new TreeNode() {{
                            setVal(4);
                        }});
                    }});
                    setRight(new TreeNode() {{
                        setVal(3);
                    }});
                }});
            }});
            setRight(new TreeNode() {{
                setVal(2);
            }});
        }};
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(treeNode2));
    }
}
