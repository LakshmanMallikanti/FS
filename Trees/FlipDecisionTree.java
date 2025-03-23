package Trees;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class FlipDecisionTree {
    // Function to flip the tree based on given rules
    public static TreeNode flipTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        // Recursively flip the left subtree
        TreeNode newRoot = flipTree(root.left);

        // Rearranging pointers to match given rules
        root.left.left = root.right; // Right child becomes left child of new root
        root.left.right = root; // Old root becomes right child

        // Remove old links
        root.left = root.right = null;

        return newRoot;
    }

    // Function to build a binary tree from given input
    public static TreeNode buildTree(int[] nodes) {
        if (nodes.length == 0)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nodes[0]);
        queue.add(root);

        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode parent = queue.poll();
            TreeNode leftChild = new TreeNode(nodes[i]);
            TreeNode rightChild = new TreeNode(nodes[i + 1]);

            parent.left = leftChild;
            parent.right = rightChild;
            queue.add(leftChild);
        }
        return root;
    }

    // Level Order Traversal to print tree nodes
    public static void printLevelOrder(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " "); // Print node value

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] nodes = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            nodes[i] = Integer.parseInt(input[i]);
        }

        TreeNode root = buildTree(nodes);
        TreeNode flippedRoot = flipTree(root);

        printLevelOrder(flippedRoot);
    }
}
