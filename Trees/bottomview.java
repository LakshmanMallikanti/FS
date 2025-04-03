package Trees;

import java.util.*;

public class bottomview {
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
        String s[] = sc.nextLine().split(" ");
        int[] a = new int[s.length];
        for (int i = 0; i < a.length; i++)
            a[i] = Integer.parseInt(s[i]);
        Node root = bt(a);
        List<List<Integer>> res = bv(root);
        System.out.println(res);

    }

    static List<List<Integer>> bv(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.get(0).add(root.val);
        insert(root.left, 1, map);
        insert(root.right, -1, map);
        for (int i : map.keySet()) {
            List<Integer> temp = map.get(i);
            if (res.size() <= i) {
                res.add(new ArrayList<>());
            }
            for (int j : temp) {
                res.get(i).add(j);
            }
        }
        return res;
    }

    static void insert(Node root, int level, HashMap<Integer, List<Integer>> map) {
        if (root == null)
            return;
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(root.val);
        insert(root.left, level + 1, map);
        insert(root.right, level - 1, map);
    }

    static Node bt(int[] a) {
        if (a.length == 0)
            return null;
        Node root = new Node(a[0]);
        Queue<Node> q = new LinkedList<>();
        int i = 1;
        while (i < a.length) {
            Node temp = q.poll();
            if (i < a.length) {
                temp.left = new Node(a[i++]);
                q.add(temp.left);

            }
            if (i < a.length) {
                temp.right = new Node(a[i++]);
                q.add(temp.right);

            }
        }
        return root;
    }
}
