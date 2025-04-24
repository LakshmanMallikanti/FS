package DSU;

import java.util.*;

class DSU {
    int[] parent;

    public DSU(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    int find(int a) {
        if (parent[a] != a)
            parent[a] = find(parent[a]); // Path compression
        return parent[a];
    }

    boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb)
            return false; // already connected => cycle
        parent[pa] = pb;
        return true;
    }
}

public class Connection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of computers (nodes)
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges.add(new int[] { u, v });
        }

        DSU dsu = new DSU(n);
        int[] redundant = new int[2];

        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                // If union fails, it's a redundant edge (cycle creator)
                redundant = edge;
            }
        }

        System.out.println(redundant[0] + " " + redundant[1]);
    }
}
