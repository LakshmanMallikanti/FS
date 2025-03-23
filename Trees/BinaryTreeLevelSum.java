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

public class BinaryTreeLevelSum {
    // Function to find the sum of nodes at level N
    public static int sumAtLevel(TreeNode root, int N) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level == N) {
                    levelSum += node.val;
                }

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            // If we reached the required level, return the sum
            if (level == N)
                return levelSum;
            level++;
        }

        return 0; // If the level N is beyond the height of the tree
    }

    public static void main(String[] args) {
        // Sample Tree:
        // 1
        // / \
        // 2 3
        // / \ \
        // 4 5 6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        int N = 2; // Find the sum of nodes at level 2 (0-based index)
        System.out.println("Sum of nodes at level " + N + " is: " + sumAtLevel(root, N));
    }
}
