package Trees;

import java.util.*;

public class VerticalShelfLibrary {
    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

    static class Tuple {
        Node node;
        int col, row;

        Tuple(Node n, int c, int r) {
            node = n;
            col = c;
            row = r;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().split(" ");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        Node root = buildTree(arr);
        List<List<Integer>> result = verticalOrderTraversal(root);
        System.out.println(result);
    }

    static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1)
            return null;
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            Node current = q.poll();

            // Left
            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                q.offer(current.left);
            }
            i++;

            // Right
            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                q.offer(current.right);
            }
            i++;
        }
        return root;
    }

    static List<List<Integer>> verticalOrderTraversal(Node root) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            Node node = t.node;
            int col = t.col, row = t.row;

            map.computeIfAbsent(col, x -> new ArrayList<>()).add(new int[] { row, node.val });

            if (node.left != null)
                q.offer(new Tuple(node.left, col - 1, row + 1));
            if (node.right != null)
                q.offer(new Tuple(node.right, col + 1, row + 1));
        }

        List<List<Integer>> result = new ArrayList<>();

        for (List<int[]> group : map.values()) {
            group.sort((a, b) -> a[0] == b[0] ? 0 : a[0] - b[0]); // sort by row
            List<Integer> colVals = new ArrayList<>();
            for (int[] pair : group)
                colVals.add(pair[1]);
            result.add(colVals);
        }

        return result;
    }
}
