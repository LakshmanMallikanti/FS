package Trees;

/*A security team is setting up surveillance cameras in a multi-floor building. 
Each floor has a certain number of cameras, and every camera is assigned 
a resolution value (in megapixels). The placement follows a hierarchical 
structure, similar to a tree:
	- Floor 0 (Ground Floor) has a single main camera (root camera).
	- From the next floor onward, each camera can have at most two sub-cameras, 
	one on the left side and one on the right side.
	- If a camera does not have a sub-camera at a position, it is represented as -1.
	
The goal is to identify the camera with the highest resolution on each floor to 
ensure optimal security coverage.

Input Format:
-------------
A single line of space separated integers, the resolution values of cameras

Output Format:
--------------
A list of integers, where eech integer represents the maximum resolution camera 
on that floor.


Sample Input-1:
---------------
2 4 3 6 4 -1 9

Sample Output-1:
----------------
[2, 4, 9]


Sample Input-2:
---------------
3 4 7 7 3 8 4 

Sample Output-2:
----------------
[3, 4, 8] */
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

public class SurveillanceCameras {

    // Function to build a Binary Tree from the given input list
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

    // Function to find the max resolution per floor
    public static List<Integer> maxResolutionPerFloor(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxRes = Integer.MIN_VALUE;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                maxRes = Math.max(maxRes, node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            result.add(maxRes);
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

        // Build tree and compute max resolution per floor
        TreeNode root = buildTree(values);
        List<Integer> maxResolutions = maxResolutionPerFloor(root);

        // Print the result
        System.out.println(maxResolutions);

        sc.close();
    }
}
