package Trees;
/*
4Q)The Indian Army has established multiple military camps at strategic locations 
along the Line of Actual Control (LAC) in Galwan. These camps are connected in 
a hierarchical structure, with a main base camp acting as the root of the network.

To fortify national security, the Government of India has planned to deploy 
a protective S.H.I.E.L.D. that encloses all military camps forming the outer 
boundary of the network.

Structure of Military Camps:
    - Each military camp is uniquely identified by an integer ID.
    - A camp can have at most two direct connections:
        - Left connection → Represents a subordinate camp on the left.
        - Right connection → Represents a subordinate camp on the right.
    - If a military camp does not exist at a specific position, it is 
      represented by -1
	
Mission: Deploying the S.H.I.E.L.D.
Your task is to determine the list of military camp IDs forming the outer 
boundary of the military network. This boundary must be traversed in 
anti-clockwise order, starting from the main base camp (root).

The boundary consists of:
1. The main base camp (root).
2. The left boundary:
    - Starts from the root’s left child and follows the leftmost path downwards.
    - If a camp has a left connection, follow it.
    - If no left connection exists but a right connection does, follow the right connection.
    - The leftmost leaf camp is NOT included in this boundary.
3. The leaf camps (i.e., camps with no further connections), ordered from left to right.
4. The right boundary (in reverse order):
    - Starts from the root’s right child and follows the rightmost path downwards.
    - If a camp has a right connection, follow it.
    - If no right connection exists but a left connection does, follow the left connection.
    - The rightmost leaf camp is NOT included in this boundary.


Input Format:
-------------
space separated integers, military-camp IDs.

Output Format:
--------------
Print all the military-camp IDs, which are at the edge of S.H.I.E.L.D.


Sample Input-1:
---------------
5 2 4 7 9 8 1

Sample Output-1:
----------------
[5, 2, 7, 9, 8, 1, 4]


Sample Input-2:
---------------
11 2 13 4 25 6 -1 -1 -1 7 18 9 10

Sample Output-2:
----------------
[11, 2, 4, 7, 18, 9, 10, 6, 13]


Sample Input-3:
---------------
1 2 3 -1 -1 -1 5 -1 6 7

Sample Output-3:
----------------
[1, 2, 7, 6, 5, 3] */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class MilitaryCampsShield {

    // Function to build a binary tree from level-order input
    public static TreeNode buildTree(int[] values) {
        if (values.length == 0)
            return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();

            if (i < values.length && values[i] != -1) {
                node.left = new TreeNode(values[i]);
                queue.offer(node.left);
            }
            i++;

            if (i < values.length && values[i] != -1) {
                node.right = new TreeNode(values[i]);
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }

    // Function to collect left boundary (excluding leaf)
    private static void getLeftBoundary(TreeNode node, List<Integer> boundary) {
        while (node != null) {
            if (node.left != null || node.right != null) // Exclude leaf nodes
                boundary.add(node.val);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    // Function to collect leaf nodes
    private static void getLeafNodes(TreeNode node, List<Integer> boundary) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            boundary.add(node.val);
            return;
        }
        getLeafNodes(node.left, boundary);
        getLeafNodes(node.right, boundary);
    }

    // Function to collect right boundary (excluding leaf, added in reverse)
    private static void getRightBoundary(TreeNode node, List<Integer> boundary) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (node.left != null || node.right != null) // Exclude leaf nodes
                stack.push(node.val);
            node = (node.right != null) ? node.right : node.left;
        }
        while (!stack.isEmpty()) {
            boundary.add(stack.pop());
        }
    }

    // Function to get boundary nodes in anti-clockwise order
    public static List<Integer> getBoundary(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (root == null)
            return boundary;

        // Add root node
        boundary.add(root.val);

        // Get left boundary
        if (root.left != null)
            getLeftBoundary(root.left, boundary);

        // Get leaf nodes
        getLeafNodes(root, boundary);

        // Get right boundary in reverse order
        if (root.right != null)
            getRightBoundary(root.right, boundary);

        return boundary;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input
        String[] input = sc.nextLine().split(" ");
        int[] values = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            values[i] = Integer.parseInt(input[i]);
        }

        // Build tree and get boundary nodes
        TreeNode root = buildTree(values);
        List<Integer> boundary = getBoundary(root);

        // Print result
        System.out.println(boundary);

        sc.close();
    }
}
