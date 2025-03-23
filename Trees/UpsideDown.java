package Trees;

import java.util.*;

public class UpsideDown {

    static class Node {
        int val;
        Node left, right; // Removed static fields

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String str = sc.nextLine();
        while (sc.hasNextInt()) { // Read until EOF
            list.add(sc.nextInt());
        }

        int[] a = list.stream().mapToInt(i -> i).toArray();
        Node root = buildTree(a, 0);

        root = flipTree(root); // Corrected: Assign the new root

        levelOrderTraversal(root); // Print after flipping
    }

    static Node buildTree(int[] a, int i) {
        if (i >= a.length) {
            return null;
        }
        Node node = new Node(a[i]); // Corrected instance creation
        node.left = buildTree(a, 2 * i + 1); // Recursively build left subtree
        node.right = buildTree(a, 2 * i + 2); // Recursively build right subtree
        return node;
    }

    public static Node flipTree(Node root) {
        if (root == null || root.left == null)
            return root;

        Node newRoot = flipTree(root.left); // Recursively get the new root
        root.left.left = root.right; // Swap right child to left's left
        root.left.right = root; // Move root to right of new root's subtree
        root.left = root.right = null; // Remove old links
        return newRoot; // Return new root
    }

    static void levelOrderTraversal(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.val + " "); // Print node

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
        System.out.println();
    }
}
