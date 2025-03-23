package Trees;

import java.util.*;

public class Preorder {

    static class Node {
        int val;
        Node left, right;

        public Node(int item) {
            this.val = item;
            this.left = this.right = null;
        }
    }

    static Node buildtree(int[] a, int i) {
        if (i >= a.length)
            return null;
        Node root = new Node(a[i]);
        root.left = buildtree(a, 2 * i + 1);
        root.right = buildtree(a, 2 * i + 2);
        return root;

    }

    static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = { 1, 2, 3, 4, 5, 6, 7 };
        Node root = buildtree(a, 0);
        System.out.println("Preorder traversal is:");
        preorder(root);

    }
}
