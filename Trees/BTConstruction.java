package Trees;

import java.util.*;

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
}