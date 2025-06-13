package Recursion;

/*Pranav has a puzzle board filled with square boxes in the form of a grid. Some 
cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

The puzzle board has some patterns formed with boxes in it, 
the patterns may be repeated. The patterns are formed with boxes (1's) only, 
that are connected horizontally and vertically but not diagonally.

Pranav wants to find out the number of unique patterns in the board.

You are given the board in the form of a grid M*N, filled wth 0's and 1's.
Your task is to help Pranav to find the number of unique patterns in 
the puzzle board.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers [0, 1].

Output Format:
--------------
Print an integer, the number of unique patterns in the puzzle board.


Sample Input-1:
---------------
5 5
0 1 0 1 1
1 1 1 0 1
0 1 0 1 0
1 0 1 1 1
1 1 0 1 0

Sample Output-1:
----------------
3

Explanation-1:
------------
The unique patterns are as follows:
  1			1 1	    1 
1 1 1		  1 ,	1 1
  1	   ,	
   
   
Sample Input-2:
---------------
6 6
1 1 0 0 1 1
1 0 1 1 0 1
0 1 0 1 0 0
1 1 0 0 0 1
0 0 1 0 1 1
1 1 0 1 0 0

Sample Output-2:
----------------
5

Explanation-2:
------------
The unique patterns are as follows:
1 1		1 1		    1		1 1	,	1
1   ,     1 ,	    1 1 ,		
 */

import java.util.*;

public class Patterns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // rows
        int m = sc.nextInt(); // cols
        int[][] a = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                vis[i][j] = false;
            }
        }

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1 && !vis[i][j]) {
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, a, vis, sb, "o"); // 'o' for origin
                    set.add(sb.toString());
                }
            }
        }

        System.out.print(set.size());
    }

    static void dfs(int i, int j, int[][] a, boolean[][] vis, StringBuilder sb, String dir) {
        int n = a.length;
        int m = a[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || a[i][j] == 0 || vis[i][j])
            return;

        vis[i][j] = true;
        sb.append(dir);

        dfs(i, j + 1, a, vis, sb, "r"); // right
        dfs(i + 1, j, a, vis, sb, "d"); // down
        dfs(i, j - 1, a, vis, sb, "l"); // left
        dfs(i - 1, j, a, vis, sb, "u"); // up

        sb.append("b"); // 'b' = backtrack
    }
}
