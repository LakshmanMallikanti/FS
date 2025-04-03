package Trees;
/*In an Intelligence Agency, each senior officer supervises either two junior officers 
or none. The senior officer is assigned a clearance level equal to the lowest clearance 
level of the two junior officers they supervise.

The clearance levels are represented as integer values in the range [1, 50], and multiple 
officers may have the same clearance level.

At the end, all officers (senior and junior) are collectively referred to as agents in the system.

You are provided with a hierarchical clearance level tree where each node represents 
an officer's clearance level. The tree structure follows these rules:
	- If a node has two children, its clearance level is the minimum of the two children's
	  clearance levels.
	- If a node has no children, it's clearance level is same as exists.
	- The value -1 indicates an empty (null) position.
Your task is to find the highest clearance level among all agents in the agency. 
If no such level exists, return -2.

Input Format:
-------------
A single line of space separated integers, clearance levels of each individual.

Output Format:
--------------
Print an integer, the highest clearance level.


Sample Input-1:
---------------
2 5 2 -1 -1 2 4

Sample Output-1:
----------------
5


Sample Input-2:
---------------
3 3 3 3 3

Sample Output-2:
----------------
3
*/

import java.util.*;

class Node {
    int val;
    Node r, l;

    Node(int val) {
        this.val = val;
        this.r = this.l = null;
    }
}

public class greater {
    public static void main(String ars[]) {
        Scanner sc = new Scanner(System.in);
        String w[] = sc.nextLine().split(" ");

        int nodes[] = new int[w.length];
        int i = 0;
        for (String x : w) {
            nodes[i++] = Integer.parseInt(x);
        }
        Node root = buildTree(nodes);
        int max = -2;
        System.out.println(findgreater(root, max));
    }

    private static Node buildTree(int[] nodes) {
        if (nodes.length == 0 || nodes[0] == -1)
            return null;
        Queue<Node> q = new LinkedList<Node>();
        Node root = new Node(nodes[0]);
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < nodes.length) {
            Node temp = q.poll();

            if (i < nodes.length && nodes[i] != -1) {
                temp.l = new Node(nodes[i]);
                q.offer(temp.l);
            }
            i++;
            if (i < nodes.length && nodes[i] != -1) {
                temp.r = new Node(nodes[i]);
                q.offer(temp.r);
            }
            i++;
        }

        return root;
    }

    private static int findgreater(Node root, int max) {
        Queue<Node> q = new LinkedList<Node>();
        if (root == null)
            return max;
        q.add(root);
        int i = 1;

        while (!q.isEmpty()) {
            Node temp = q.poll();

            max = Math.max(temp.val, max);
            if (temp.l != null)
                q.offer(temp.l);
            if (temp.r != null)
                q.offer(temp.r);
        }

        return max;
    }
} // note I used level order traversal but gogte sir would appreciate recursive
  // approach
