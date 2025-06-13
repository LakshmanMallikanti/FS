package DSU;

import java.util.*;

public class Connections {
    static int parent[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[][] a = new int[c][2];
        for (int i = 0; i < c; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            union(a[i][0], a[i][1]);
        }
        Set<Integer> groups = new HashSet<>();
        Set<Integer> connected = new HashSet<>();
        int changes = 0;
        int free = 0;
        for (int i = 0; i < c; i++) {
            if (find(a[i][0]) == find(a[i][1])) {
                if (connected.contains(a[i][0]) && connected.contains(a[i][1])) {
                    free++;
                } else {
                    connected.add(a[i][0]);
                    connected.add(a[i][1]);
                }
            } else {
                connected.add(a[i][0]);
                connected.add(a[i][1]);
            }
        }
        for (int i = 0; i < n; i++) {
            groups.add(parent[i]);
        }
        if (groups.size() - 1 <= free) {
            System.out.print(groups.size() - 1);
        } else {
            System.out.print(-1);
        }
    }

    static void union(int a, int b) {
        int l = find(a);
        int r = find(b);
        if (l < r)
            parent[r] = l;
        else
            parent[l] = r;
    }

    static int find(int a) {
        if (parent[a] != a)
            parent[a] = find(parent[a]);
        return parent[a];
    }
}