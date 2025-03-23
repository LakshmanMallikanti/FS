package Trees;

import java.util.*;

public class DepthOfNode {

    static class Node {
        int val;
        Node right, left;

        public Node(int val) {
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int target = sc.nextInt();
        int[] a = new int[s.length];
        for (int i = 0; i < s.length; i++)
            a[i] = Integer.parseInt(s[i]);
        Node root = bt(a);
        int depth = df(root, target, 0);
        System.out.println(depth);
    }

    static Node bt(int[] a) {
        if (a.length == 0)
            return null;
        Node root = new Node(a[0]);
        Queue<Node> q = new LinkedList<>();
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

    static int df(Node root, int tar, int depth) {
        if (root == null)
            return -1;
        if (root.val == tar)
            return depth;
        int leftl = df(root.left, tar, depth + 1);
        if (leftl != -1) {
            return leftl;
        }
        return df(root.right, tar, depth + 1);
    }
}
