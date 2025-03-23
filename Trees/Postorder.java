package Trees;

import java.util.*;

public class Postorder {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static Node buildTree(int arr[], int i) {
        if (i >= arr.length)
            return null;
        Node root = new Node(arr[i]);
        root.right = buildTree(arr, 2 * i + 2);
        root.left = buildTree(arr, 2 * i + 1);
        return root;
    }

    static void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Node root = buildTree(arr, 0);
        postorder(root);
    }
}
