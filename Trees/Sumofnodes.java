package Trees;

import java.util.Scanner;

public class Sumofnodes {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static Node buildTree(int[] arr, int i) {
        if (i >= arr.length)
            return null;
        Node root = new Node(arr[i]);
        root.left = buildTree(arr, 2 * i + 1);
        root.right = buildTree(arr, 2 * i + 2);
        return root;
    }

    static int sumNodes(Node root) {
        if (root == null)
            return 0;
        return root.val + sumNodes(root.left) + sumNodes(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Node root = buildTree(arr, 0);
        System.out.println("Number of nodes in the tree: " + sumNodes(root));
    }
}
