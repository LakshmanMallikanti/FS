package Trees;

import java.util.*;

public class Levelorder2 {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
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

    static void printNthLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.val + " ");
        } else {
            printNthLevel(root.left, level - 1);
            printNthLevel(root.right, level - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Node root = buildTree(arr, 0);
        int level = sc.nextInt();
        printNthLevel(root, level);
    }
}
