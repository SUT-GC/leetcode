package lc117;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mate.Node;

public class Solution {
    public Node connect(Node root) {
        if (null == root) {
            return null;
        }

        List<Node> fq = new ArrayList<>();
        List<Node> sq = new ArrayList<>();

        fq.add(root);

        while (!fq.isEmpty() || !sq.isEmpty()) {

            if (!fq.isEmpty()) {
                link(fq);
                fq.forEach(p -> {
                    if (null != p.left) sq.add(p.left);
                    if (null != p.right) sq.add(p.right);
                });
                fq.clear();
                continue;
            }

            if (!sq.isEmpty()) {
                link(sq);
                sq.forEach(p -> {
                    if (null != p.left) fq.add(p.left);
                    if (null != p.right) fq.add(p.right);
                });
                sq.clear();
                continue;
            }
        }

        return root;
    }

    public void link(List<Node> list) {
        if (list == null || list.size() <= 1) {
            return;
        }

        Node a = list.get(0);


        for (int i = 1; i < list.size(); i++) {
            Node b = list.get(i);
            a.next = b;

            a = b;
        }
    }
}
