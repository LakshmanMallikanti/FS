package Trees;

public class BinaryTree {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static Node binaryTree(int[] arr, int i) {
        if (i >= arr.length)
            return null;

        Node root = new Node(arr[i]);
        root.left = binaryTree(arr, 2 * i + 1);
        root.right = binaryTree(arr, 2 * i + 2);

        return root;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        Node root = binaryTree(arr, 0);
    }
}
