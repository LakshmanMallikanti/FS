package Trees;

/*
Mr. Rakesh is interested in working with Data Structures.

He has constructed a Binary Tree (BT) and asked his friend 
Anil to check whether the BT is a self-mirror tree or not.

Can you help Rakesh determine whether the given BT is a self-mirror tree?
Return true if it is a self-mirror tree; otherwise, return false.

Note:
------
In the tree, '-1' indicates an empty (null) node.

Input Format:
-------------
A single line of space separated integers, values at the treenode

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 1 1 2 3 3 2

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 1 1 -1 3 -1 3

Sample Output-2:
----------------
false
*/
import java.util.*;

class Node {
    int val;
    Node left, right;

    public Node(int val) {
        this.val = val;
        this.right = null;
        this.left = null;
    }
}

public class BTMirror {
    public static void main(String... input) {
        Scanner sc = new Scanner(System.in);
        String[] n = sc.nextLine().split(" ");
        int[] a = new int[n.length];
        for (int i = 0; i < n.length; i++)
            a[i] = Integer.parseInt(n[i]);
        Node root = bt(a);
        print(root);
        System.out.print(check(root.left, root.right));
    }

    static Node bt(int[] a) {
        if (a.length == 0 || a[0] == -1)
            return null;
        Node root = new Node(a[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < a.length) {
            Node current = q.poll();
            if (i < a.length && a[i] != -1) {
                current.left = new Node(a[i]);
                q.offer(current.left);
            }
            i++;
            if (i < a.length && a[i] != -1) {
                current.right = new Node(a[i]);
                q.offer(current.right);
            }
            i++;
        }
        return root;
    }

    static boolean check(Node lroot, Node rroot) {
        if (lroot == null && rroot == null)
            return true;
        if (lroot == null || rroot == null)
            return false;
        if (lroot.val != rroot.val)
            return false;
        return check(lroot.left, rroot.right) && check(lroot.right, rroot.left);
    }

    static void print(Node root) {
        Queue<Node> q1 = new LinkedList<>();
        q1.offer(root);
        while (!q1.isEmpty()) {
            Node r = q1.poll();
            System.out.print(r.val + " ");

            if (r.left != null) {
                q1.offer(r.left);
            }

            if (r.right != null) {

                q1.offer(r.right);

            }
        }
    }
}
