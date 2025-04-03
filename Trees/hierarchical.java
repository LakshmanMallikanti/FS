package Trees;

/*
 * In an Intelligence Agency, each senior officer supervises either two junior officers 
or none. The senior officer is assigned a clearance level equal to the higher clearance 
level of the two junior officers they supervise.

The clearance levels are represented as integer values in the range [1, 50], and 
multiple officers may have the same clearance level.

At the end, all officers (senior and junior) are collectively referred to as 
agents in the system.

You are provided with a hierarchical clearance level tree where each node represents 
an officer's clearance level. The tree structure follows these rules:
	- If a node has two children, its clearance level is the maximum of the two children's
	  clearance levels.
	- If a node has no children, it's clearance level is same as exists.
	- The value -1 indicates an empty (null) position.
Your task is to find the second highest clearance level among all agents in the agency. 
If no such level exists, return -2.

Input Format:
-------------
A single line of space separated integers, clearance levels of each individual.

Output Format:
--------------
Print an integer, second top agent based on rank.


Sample Input-1:
---------------
5 5 4 -1 -1 2 4

Sample Output-1:
----------------
4


Sample Input-2:
---------------
3 3 3 3 3

Sample Output-2:
----------------
-2
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class hierarchical {

    public static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1"))
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        int i = 1;

        while (i < nodes.length) {
            TreeNode current = queue.poll();

            if (i < nodes.length && !nodes[i].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static int findSecondHighest(TreeNode root) {
        Set<Integer> clearanceLevels = new TreeSet<>(Collections.reverseOrder());
        collectClearanceLevels(root, clearanceLevels);

        Iterator<Integer> it = clearanceLevels.iterator();
        if (it.hasNext()) {
            it.next(); // Highest level
            if (it.hasNext()) {
                return it.next(); // Second highest level
            }
        }
        return -2;
    }

    private static void collectClearanceLevels(TreeNode root, Set<Integer> levels) {
        if (root == null)
            return;
        levels.add(root.val);
        collectClearanceLevels(root.left, levels);
        collectClearanceLevels(root.right, levels);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        TreeNode root = buildTree(input);
        System.out.println(findSecondHighest(root));
    }
}
