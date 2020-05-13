package gen;

import mate.TreeNode;

public class TreeGen {
    public TreeNode gen572_1() {
        return new TreeNode() {{
            setVal(3);
            setLeft(new TreeNode() {{
                setVal(4);
                setLeft(new TreeNode() {{
                    setVal(1);
                }});
                setRight(new TreeNode() {{
                    setVal(2);
                    setLeft(new TreeNode() {{
                        setVal(0);
                    }});
                }});
            }});
            setRight(new TreeNode() {{
                setVal(5);
            }});
        }};
    }

    public TreeNode gen572_2() {
        return new TreeNode() {{
            setVal(4);
            setLeft(new TreeNode() {{
                setVal(1);
            }});
            setRight(new TreeNode() {{
                setVal(2);
            }});
        }};
    }

    public TreeNode gen236_1() {
        return new TreeNode() {{
            setVal(3);
            setLeft(new TreeNode() {{
                setVal(5);
                setLeft(new TreeNode() {{
                    setVal(6);
                }});
                setRight(new TreeNode() {{
                    setVal(2);
                    setLeft(new TreeNode() {{
                        setVal(7);
                    }});
                    setRight(new TreeNode() {{
                        setVal(4);
                    }});
                }});
            }});
            setRight(new TreeNode() {{
                setVal(1);
                setLeft(new TreeNode() {{
                    setVal(0);
                }});
                setRight(new TreeNode() {{
                    setVal(8);
                }});
            }});
        }};
    }

    public TreeNode gen236_2() {
        return new TreeNode() {{
            setVal(5);
        }};
    }

    public TreeNode gen236_3() {
        return new TreeNode() {{
            setVal(3);
        }};
    }
}
