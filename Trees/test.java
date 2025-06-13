import java.util.*;

class Node {
    int val;
    Node left, right;

    public Node(int val) {
        this.val = val;
        right = null;
        left = null;
    }
}

public class test {
    static int ii = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] in = new int[n];
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            pre[i] = sc.nextInt();
        Node root = bt(in, pre);
        bfs(root);
    }

    static Node bt(int[] in, int[] pre) {
        if (in.length == 0)
            return null;

        int index = bs(pre[ii], in);
        if (index == -1)
            return null;

        Node root = new Node(pre[ii]);
        ii++;

        root.left = bt(Arrays.copyOfRange(in, 0, index), pre);
        root.right = bt(Arrays.copyOfRange(in, index + 1, in.length), pre);
        return root;
    }

    static int bs(int k, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == k)
                return i;
        }
        return -1;
    }

    static void bfs(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null)
                q.offer(temp.left);
            if (temp.right != null)
                q.offer(temp.right);
        }
    }
}
/*
 * Alex and his twin brother Jordan often create secret messages. One day,
 * Jordan
 * gives Alex two encrypted messages and challenges him to find the longest
 * common
 * palindromic pattern hidden within both messages.
 * 
 * Alex wants your help to decode the longest common palindromic subsequence
 * that
 * exists in both strings.
 * 
 * Your task is to determine the length of the longest subsequence that:
 * - Appears in both messages
 * - Is a palindrome
 * 
 * Input Format:
 * -------------
 * input1: A string representing the first encrypted message.
 * input2: A string representing the second encrypted message.
 * 
 * Output Fromat:
 * --------------
 * Return an integer representing the length of the longest common palindromic
 * subsequence shared by both messages.
 * 
 * 
 * Sample Input:
 * -------------
 * adfa
 * aagh
 * 
 * Sample Output:
 * --------------
 * 2
 * 
 * 
 * Sample Input-2:
 * ---------------
 * abcda
 * fxaaba
 * 
 * Sample Output:
 * --------------
 * 3
 * 
 * Explanation:
 * ------------
 * The longest palindromic subsequence common to both is "aba" with length 3.
 */