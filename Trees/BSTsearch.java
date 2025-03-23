package Trees;

import java.util.*;

public class BSTsearch {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);
        if (key < root.val)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return root;
    }

    static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.val == key) {
            return true;
        }
        if (root.val < key) {
            return search(root.right, key);
        }
        return search(root.left, key);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        System.out.println(search(root, 6));

    }
}
