package Trees;

import java.util.*;

public class WebsitePages {
    // Define the Node class for the binary tree
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    // Method to build the binary tree from level-order input
    public static Node buildTree(int[] elements) {
        if (elements.length == 0)
            return null;

        Node root = new Node(elements[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < elements.length) {
            Node temp = queue.poll();

            // Assign the left child
            if (i < elements.length) {
                temp.left = new Node(elements[i++]);
                queue.add(temp.left);
            }

            // Assign the right child
            if (i < elements.length) {
                temp.right = new Node(elements[i++]);
                queue.add(temp.right);
            }
        }

        return root;
    }

    // Method to count pages where the value equals the sum of its descendants
    public static int countPages(Node root) {
        if (root == null)
            return 0;

        int[] count = new int[1]; // To hold the count (using an array to allow modification in recursion)
        calculateDescendantsSum(root, count);
        return count[0];
    }

    // Method to calculate sum of descendants and check the condition
    private static int calculateDescendantsSum(Node node, int[] count) {
        if (node == null)
            return 0; // Base case: null node has no descendants

        // Calculate the sum of the left and right subtrees
        int leftSum = calculateDescendantsSum(node.left, count);
        int rightSum = calculateDescendantsSum(node.right, count);

        // Sum of all descendants
        int totalSum = leftSum + rightSum;

        // If the node's value is equal to the sum of its descendants, increment the
        // count
        if (node.val == totalSum) {
            count[0]++; // Increment the result count
        }

        // Return the total sum including the node itself
        return totalSum + node.val;
    }

    public static void main(String[] args) {
        // Read the input
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] elements = new int[input.length];

        // Convert input to an integer array
        for (int i = 0; i < input.length; i++) {
            elements[i] = Integer.parseInt(input[i].trim());
        }

        // Build the tree from the input
        Node root = buildTree(elements);

        // Count the pages where value equals sum of descendants
        int result = countPages(root);

        // Output the result
        System.out.println(result);
    }
}
