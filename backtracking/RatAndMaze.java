package backtracking;

import java.util.*;

public class RatAndMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        List<String> ans = new ArrayList<>();
        if (maze[0][0] == 1) { // Start point must be open
            bt(maze, 0, 0, "", ans);
        }

        Collections.sort(ans); // sort the paths lexicographically once
        for (String path : ans) {
            System.out.print(path + " ");
        }
        System.out.println();
    }

    public static void bt(int[][] maze, int i, int j, String path, List<String> ans) {
        int n = maze.length;
        if (i < 0 || j < 0 || i >= n || j >= n || maze[i][j] == 0) {
            return;
        }

        if (i == n - 1 && j == n - 1) {
            ans.add(path);
            return;
        }

        maze[i][j] = 0; // mark as visited

        bt(maze, i + 1, j, path + "D", ans); // down
        bt(maze, i, j + 1, path + "R", ans); // right
        bt(maze, i - 1, j, path + "U", ans); // up
        bt(maze, i, j - 1, path + "L", ans); // left

        maze[i][j] = 1; // unmark for backtracking
    }
}
