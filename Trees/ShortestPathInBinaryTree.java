package Trees;

/*
 * Bubloo is working with computer networks, where servers are connected
 * in a hierarchical structure, represented as a Binary Tree. Each server (node)
 * is uniquely identified by an integer value.
 * 
 * Bubloo has been assigned an important task: find the shortest communication
 * path (in terms of network hops) between two specific servers in the network.
 * 
 * Network Structure:
 * ------------------
 * The network of servers follows a binary tree topology.
 * Each server (node) has a unique identifier (integer).
 * If a server does not exist at a certain position, it is represented as '-1'
 * (NULL).
 * 
 * Given the root of the network tree, and two specific server IDs (E1 & E2),
 * determine the minimum number of network hops (edges) required to
 * communicate between these two servers.
 * 
 * Input Format:
 * -------------
 * Space separated integers, elements of the tree.
 * 
 * Output Format:
 * --------------
 * Print an integer value.
 * 
 * 
 * Sample Input-1:
 * ---------------
 * 1 2 4 3 5 6 7 8 9 10 11 12
 * 4 8
 * 
 * Sample Output-1:
 * ----------------
 * 4
 * 
 * Explanation:
 * ------------
 * The edegs between 4 and 8 are: [4,1], [1,2], [2,3], [3,8]
 * 
 * 
 * Sample Input-2:
 * ---------------
 * 1 2 4 3 5 6 7 8 9 10 11 12
 * 6 6
 * 
 * Sample Output-2:
 * ----------------
 * 0
 * 
 * Explanation:
 * ------------
 * No edegs between 6 and 6.
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class ShortestPathInBinaryTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] elements = sc.nextLine().split(" ");
        int e1 = sc.nextInt(), e2 = sc.nextInt();

        TreeNode root = buildTree(elements);
        int distance = findShortestPath(root, e1, e2);
        System.out.println(distance);
    }

    // Building the Binary Tree
    private static TreeNode buildTree(String[] elements) {
        if (elements.length == 0 || elements[0].equals("-1"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(elements[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < elements.length) {
            TreeNode current = queue.poll();

            if (i < elements.length && !elements[i].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(elements[i]));
                queue.offer(current.left);
            }
            i++;

            if (i < elements.length && !elements[i].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(elements[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    // Find LCA (Lowest Common Ancestor)
    private static TreeNode findLCA(TreeNode root, int e1, int e2) {
        if (root == null || root.val == e1 || root.val == e2)
            return root;

        TreeNode left = findLCA(root.left, e1, e2);
        TreeNode right = findLCA(root.right, e1, e2);

        if (left != null && right != null)
            return root;
        return (left != null) ? left : right;
    }

    // Find the distance from LCA to a node
    private static int findDepth(TreeNode root, int target, int depth) {
        if (root == null)
            return -1;
        if (root.val == target)
            return depth;

        int left = findDepth(root.left, target, depth + 1);
        if (left != -1)
            return left;

        return findDepth(root.right, target, depth + 1);
    }

    // Find the shortest path
    private static int findShortestPath(TreeNode root, int e1, int e2) {
        TreeNode lca = findLCA(root, e1, e2);
        if (lca == null)
            return -1;

        int d1 = findDepth(lca, e1, 0);
        int d2 = findDepth(lca, e2, 0);

        return d1 + d2;
    }
}