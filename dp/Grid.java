
/*
You’re given an m x n grid. You can only move right or down from any cell.
How many unique ways are there to reach the bottom-right from top-left?

*/
import java.util.*;

public class Grid {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(countPaths(n - 1, m - 1));
    }

    static int countPaths(int n, int m) {
        if (n < 0 || m < 0) {
            return 0; // Out of bounds
        }
        if (n == 0 && m == 0) {
            return 1; // Reached the destination
        }
        if (dp[n][m] != -1) {
            return dp[n][m]; // Return cached result
        }
        // Count paths from the cell above and the cell to the left
        return dp[n][m] = countPaths(n - 1, m) + countPaths(n, m - 1);
    }

    static int countPathsTab(int n, int m) {
        int[][] dp2 = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp2[i][j] = 1;
                } else {
                    int up = i > 0 ? dp[i - 1][j] : 0;
                    int left = j > 0 ? dp[i][j - 1] : 0;
                    dp2[i][j] = up + left;
                }
            }
        }

        return dp2[n - 1][m - 1];
    }

}