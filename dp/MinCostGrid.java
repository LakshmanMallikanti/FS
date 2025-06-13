
/*
  You're given a n x m grid. Each cell has a cost to enter.
Find the minimum cost path from the top-left (0,0) to bottom-right (n-1,m-1), moving only right or down.

🔹 If there are obstacles (optional) → cost can be set to -1 or Integer.MAX_VALUE to skip them.


 */
import java.util.*;

public class MinCostGrid {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.print(LeastCost(grid, n, m));
    }

    static int LeastCost(int[][] grid, int n, int m) {
        if (grid[0][0] == -1)
            return -1; // Can't start

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == -1) {
                    dp[i][j] = Integer.MAX_VALUE; // Mark unreachable
                } else if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j]; // Starting cell
                } else {
                    int up = (i > 0 && dp[i - 1][j] != Integer.MAX_VALUE) ? dp[i - 1][j] : Integer.MAX_VALUE;
                    int left = (j > 0 && dp[i][j - 1] != Integer.MAX_VALUE) ? dp[i][j - 1] : Integer.MAX_VALUE;

                    dp[i][j] = (up == Integer.MAX_VALUE && left == Integer.MAX_VALUE)
                            ? Integer.MAX_VALUE
                            : Math.min(up, left) + grid[i][j];
                }
            }
        }

        return dp[n - 1][m - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1][m - 1];
    }
}
