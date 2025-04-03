package Trees;

/*import java.util.*;

public class BTConstruction {

    static class Node {
        int val;
        Node right, left;

        public Node(int val) {
            this.val = val;

        }
    }

    public void buildTree(int[] elements) {
        if (elements.length == 0)
            return;
        Node root = new Node(elements[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < elements.length) {
            Node temp = queue.poll();

            if (i < elements.length) {
                temp.left = new Node(elements[i++]);
                queue.add(temp.left);
            }

            if (i < elements.length) {
                temp.right = new Node(elements[i++]);
                queue.add(temp.right);
            }
        }
    }
}*/
import java.util.*;

public class BTConstruction {
    static class Node {
        int val;
        Node right, left;

        public Node(int val) {
            this.val = val;
            this.right = this.left = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] c = sc.nextLine().split(" ");
        int[] a = new int[c.length];
        for (int i = 0; i < c.length; i++)
            a[i] = Integer.parseInt(c[i]);
        Node root = buildTree(a);
        int cc = count(root);
        System.out.print(cc);
    }

    public static Node buildTree(int[] elements) {
        /*
         * if (elements.length == 0)
         * return null;
         * Node root = new Node(elements[0]);
         * Queue<Node> queue = new LinkedList<>();
         * queue.add(root);
         * int i = 1;
         * while (i < elements.length) {
         * Node temp = queue.poll();
         * if (i < elements.length) {
         * temp.left = new Node(elements[i++]);
         * queue.add(temp.left);
         * }
         * if (i < elements.length) {
         * temp.right = new Node(elements[i++]);
         * queue.add(temp.right);
         * }
         * }
         * 
         * return root;
         */
        if (elements.length == 0)
            return null;
        Node root = new Node(elements[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < elements.length) {
            Node temp = q.poll();
            if (i < elements.length) {
                temp.left = new Node(elements[i++]);
                q.offer(temp.left);
            }
            if (i < elements.length) {
                temp.right = new Node(elements[i++]);
                q.offer(temp.right);
            }
        }
        return root;
    }

    static int count(Node root) {
        if (root != null && root.val == 0)
            return 1;
        int c = count(root.left) + count(root.right);
        if (root == null)
            return 0;
        if (root.left != null && root.right != null) {
            if (root.val == root.left.val + root.right.val) {
                root.val = root.left.val + root.right.val;
                return 1;

            }

        }
        return c;

    }

}