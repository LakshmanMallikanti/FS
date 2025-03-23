package Trees;

/*
 You are developing an application for a garden management system where each tree 
in the garden is represented as a binary tree structure. The system needs to 
allow users to plant new trees in a systematic way, ensuring that each tree is 
filled level by level.

A gardener wants to:
 - Plant trees based on user input.
 - Ensure trees grow in a balanced way by filling nodes level by level.
 - Inspect the garden layout by performing an in-order traversal, which helps 
   analyze the natural arrangement of trees.

Your task is to implement a program that:
    - Accepts a list of N tree species (as integers).
    - Builds a binary tree using level-order insertion.
    - Displays the in-order traversal of the tree.

Input Format:
-------------
- An integer N representing the number of tree plants.
- A space-separated list of N integers representing tree species.

Output Format:
--------------
A list of integers, in-order traversal of tree.


Sample Input:
-------------
7
1 2 3 4 5 6 7

Sample Output:
--------------
4 2 5 1 6 3 7


Explanation:
------------
The tree looks like this:

        1
       / \
      2   3
     / \  / \
    4   5 6  7
The in order is : 4 2 5 1 6 3 7

 */
import java.util.*;

public class Inorder {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static Node BuildTree(int[] arr) {
        if (arr.length == 0)
            return null;
        Queue<Node> q = new LinkedList<>();
        int i = 0;
        Node root = new Node(arr[i]);
        q.add(root);
        i++;
        while (i < arr.length) {
            Node cur = q.poll();
            if (i < arr.length) {
                cur.left = new Node(arr[i]);
                q.add(cur.left);
                i++;
            }
            if (i < arr.length) {
                cur.right = new Node(arr[i]);
                q.add(cur.right);
                i++;
            }
        }
        return root;

    }

    static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.val + " ");
            inorder(node.right);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Node root = BuildTree(arr);
        inorder(root);

    }
}