package Trees;

import java.util.*;

class Node {
    int val;
    Node left, right;

    public Node(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class ShortestBinaryPath {
    public static void main(String... input) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int a1 = sc.nextInt();
        int b = sc.nextInt();
        int a[] = new int[s.length];
        for (int i = 0; i < s.length; i++)
            a[i] = Integer.parseInt(s[i]);
        Node root = bt(a);
        Node lca = LCA(root, a1, b);
        int d1 = depth(lca, a1, 0);
        int d2 = depth(lca, b, 0);
        if (d1 != -1 && d2 != -1) {
            if (a1 == b) {
                System.out.println(0);
                return;
            }
            System.out.print(d1 + d2);
        } else {
            System.out.print(-1);
        }

    }

    static Node bt(int[] a) {
        if (a.length == 0)
            return null;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(a[0]);
        q.add(root);
        int i = 1;
        while (i < a.length) {
            Node temp = q.poll();
            if (i < a.length) {
                temp.left = new Node(a[i++]);
                q.add(temp.left);
            }
            if (i < a.length) {
                temp.right = new Node(a[i++]);
                q.add(temp.right);
            }
        }
        return root;
    }

    static Node LCA(Node root, int a, int b) {
        if (root == null)
            return null;
        if (root.val == a || root.val == b)
            return root;
        Node lt = LCA(root.left, a, b);
        Node rt = LCA(root.right, a, b);
        if (lt != null && rt != null)
            return root;
        if (lt == null)
            return rt;
        else
            return lt;
    }

    static int depth(Node root, int a, int depth) {
        if (root == null)
            return -1;
        if (root.val == a)
            return depth;
        int ldepth = depth(root.left, a, depth + 1);
        if (ldepth != -1)
            return ldepth;
        return depth(root.right, a, depth + 1);
    }
}
