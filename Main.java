
/*
 * import java.util.*;
 * 
 * public class test {
 * public static void main(String[] args) {
 * Scanner sc = new Scanner(System.in);
 * String[] s = sc.nextLine().split(" ");
 * if (s[1].length() % s[0].length() != 0 && s[0].length() % s[1].length() != 0)
 * {
 * System.out.print(false);
 * return;
 * }
 * if (s[0].length() > s[1].length()) {
 * String temp = s[0];
 * s[0] = s[1];
 * s[1] = temp;
 * }
 * int k = s[1].length() / s[0].length();
 * Map<Character, String> map = new HashMap<>();
 * for (int i = 0; i < s[0].length(); i++) {
 * map.put(s[0].charAt(i), " ");
 * }
 * 
 * for (int i = 0; i < s[0].length(); i++) {
 * if (!map.get(s[0].charAt(i)).equals(" ")
 * && !map.get(s[0].charAt(i)).equals(s[1].substring(i * k, i * k + k))) {
 * 
 * System.out.print(false);
 * return;
 * }
 * 
 * map.put(s[0].charAt(i), s[1].substring(i * k, i * k + k));
 * }
 * 
 * System.out.print(map);
 * }
 * }
 */
/*
/* 
 * import java.util.*;
 * 
 * public class test {
 * public static void main(String[] args) {
 * Scanner sc = new Scanner(System.in);
 * String[] s = sc.next().split("B");
 * if (s.length == 0) {
 * System.out.println(false);
 * return;
 * }
 * if (s.length > 1) {
 * int count = 0;
 * for (int i = 0; i < s.length; i++) {
 * if (s[i].length() > 3)
 * count++;
 * if (count == 2) {
 * System.out.println(true);
 * return;
 * }
 * }
 * System.out.println(false);
 * return;
 * } else {
 * if (s[0].length() < 2 || s[0].length() == 5) {
 * System.out.println(false);
 * return;
 * }
 * 
 * }
 * System.out.print(true);
 * 
 * }
 * 
 * }
 */
/*The government has set up a network of smart traffic lights connected 
by roads, forming a tree structure with n traffic lights. Each road has a 
communication delay measured in meters.

Each road connects exactly two traffic lights, and all lights are connected 
(i.e., there are no cycles).

To maintain secure and efficient signal relays, the system allows only indirect
communication — where two traffic lights can communicate via a third traffic 
light (called the mediator) if:

The total signal path length (distance from light A to mediator to light B) is 
divisible by a given signal propagation speed.

You are to compute, for each traffic light, the number of such valid (A → B) 
communication pairs that it can mediate.

Input Format:
-------------
Line-1: An integer N     // number of traffic lights
Line-2: N-1 space sepearted integers,  light_from[].
Line-3: N-1 space sepearted integers,  light_to[].
Line-4: N-1 space sepearted integers,  road_lengths[].
Line-5: An integer, signal_speed    // signal propagation speed

Output Format:
---------------
An array of size n, where the ith value is the number of valid pairs 
that use traffic light i+1 as a mediator


Sample Input:
-------------
4
1 1 2
2 3 4
2 5 3
5

Sample Output:
--------------
2 0 2 2
 *//* 
        import java.util.*;
        
        public class Main {
         static int[][] dist;
        
         public static void main(String[] args) {
             Scanner sc = new Scanner(System.in);
        
             int n = sc.nextInt(); // number of traffic lights
        
             int[] from = new int[n - 1];
             int[] to = new int[n - 1];
             int[] length = new int[n - 1];
        
             for (int i = 0; i < n - 1; i++)
                 from[i] = sc.nextInt();
             for (int i = 0; i < n - 1; i++)
                 to[i] = sc.nextInt();
             for (int i = 0; i < n - 1; i++)
                 length[i] = sc.nextInt();
        
             int signalSpeed = sc.nextInt();
        
             // Build the tree (undirected)
             Map<Integer, List<int[]>> tree = new HashMap<>();
             for (int i = 0; i < n - 1; i++) {
                 tree.computeIfAbsent(from[i], k -> new ArrayList<>()).add(new int[] { to[i], length[i] });
                 tree.computeIfAbsent(to[i], k -> new ArrayList<>()).add(new int[] { from[i], length[i] });
             }
        
             // Distance matrix: dist[i][j] = distance from i to j
             dist = new int[n + 1][n + 1];
        
             // Compute distances from each node
             for (int i = 1; i <= n; i++) {
                 dfs(i, i, -1, 0, tree);
             }
        
             // For each node, count valid (A, B) pairs with it as mediator
             int[] result = new int[n];
             for (int m = 1; m <= n; m++) {
                 int count = 0;
                 for (int a = 1; a <= n; a++) {
                     if (a == m)
                         continue;
                     for (int b = a + 1; b <= n; b++) {
                         if (b == m)
                             continue;
                         int total = dist[a][m] + dist[m][b];
                         if (total % signalSpeed == 0)
                             count++;
                     }
                 }
                 result[m - 1] = count;
             }
        
             // Print result
             for (int val : result) {
                 System.out.print(val + " ");
             }
         }
        
         // DFS to calculate distances from src to all nodes
         static void dfs(int src, int node, int parent, int cost, Map<Integer, List<int[]>> tree) {
             dist[src][node] = cost;
             for (int[] neighbor : tree.getOrDefault(node, new ArrayList<>())) {
                 int next = neighbor[0];
                 int edgeCost = neighbor[1];
                 if (next != parent) {
                     dfs(src, next, node, cost + edgeCost, tree);
                 }
             }
         }
        }
        
        
        
        
        
        ****************************************/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        ArrayList<HashSet<Character>> a = new ArrayList<>();
        for (int i = 0; i < s[0].length(); i++) {
            Set<Character> set = new HashSet<>();
            if (a.size() == 0) {
                set.add(s[0].charAt(i));
                set.add(s[1].charAt(i));
            }
            boolean flag = false;
            for (HashSet<Character> h : a) {
                if (h.contains(s[0].charAt(i)) && (h.contains(s[1].charAt(i)))) {
                    flag = true;
                    break;
                }
                if (h.contains(s[0].charAt(i))) {
                    h.add(s[1].charAt(i));
                    flag = true;
                    break;
                }
                if (h.contains(s[1].charAt(i))) {
                    h.add(s[0].charAt(i));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                set.add(s[1].charAt(i));
                set.add(s[0].charAt(i));
            }
        }
        System.out.println(a);
    }
}