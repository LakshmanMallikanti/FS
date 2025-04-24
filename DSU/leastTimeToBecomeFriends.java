package DSU;

import java.util.*;

class DSU {
    int[] parent;
    int groups;

    public DSU(int n) {
        parent = new int[n];
        groups = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int a) {
        if (parent[a] != a)
            parent[a] = find(parent[a]);
        return parent[a];
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            parent[pb] = pa;
            groups--;
        }
    }
}

public class leastTimeToBecomeFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();

        int[][] logs = new int[L][3];
        for (int i = 0; i < L; i++) {
            logs[i][0] = sc.nextInt(); // time
            logs[i][1] = sc.nextInt(); // person A
            logs[i][2] = sc.nextInt(); // person B
        }

        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0])); // sort by time

        DSU dsu = new DSU(N);
        for (int i = 0; i < L; i++) {
            dsu.union(logs[i][1], logs[i][2]);
            if (dsu.groups == 1) {
                System.out.println(logs[i][0]);
                return;
            }
        }
        System.out.println(-1);
    }
}
