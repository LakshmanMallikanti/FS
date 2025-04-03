package Trees;

/*A software development company is designing a smart home automation 
system that uses sensor networks to monitor and control different devices 
in a house. The sensors are organized in a hierarchical structure, where each 
sensor node has a unique ID and can have up to two child nodes (left and right).

The company wants to analyze the left-most sensors in the system to determine
which ones are critical for detecting environmental changes. The hierarchy of 
the sensors is provided as a level-order input, where missing sensors are 
represented as -1.

Your task is to build the sensor network as a binary tree and then determine 
the left-most sensor IDs at each level.

Input Format:
-------------
Space separated integers, elements of the tree.

Output Format:
--------------
A list of integers representing the left-most sensor IDs at each level


Sample Input-1:
---------------
1 2 3 4 -1 -1 5

Sample Output-1:
----------------
[1, 2, 4]



Sample Input-2:
---------------
3 2 4 1 5

Sample Output-2:
----------------
[3, 2, 1] */
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

public class LeftMostSensors {

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

    // Function to get left-most nodes at each level
    public static List<Integer> leftMostSensors(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            result.add(queue.peek().val); // First node at this level

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input
        String[] input = sc.nextLine().split(" ");
        int[] values = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            values[i] = Integer.parseInt(input[i]);
        }

        // Build tree and find left-most sensors
        TreeNode root = buildTree(values);
        List<Integer> leftMost = leftMostSensors(root);

        // Print result
        System.out.println(leftMost);

        sc.close();
    }
}
