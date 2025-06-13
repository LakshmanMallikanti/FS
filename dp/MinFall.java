
/*🧩 Problem 1: Minimum Falling Path Sum
You are given an n x n integer matrix grid, return the minimum falling path sum from the top to the bottom of the matrix.

Rules:

You may move directly down, down-left, or down-right. */
import java.util.*;

public class MinFall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = grid[n - 1][i];

        for (int row = n - 2; row >= 0; row--) {
            int[] cur = new int[n];
            for (int col = 0; col < n; col++) {
                int down = dp[col];
                int left = col > 0 ? dp[col - 1] : Integer.MAX_VALUE;
                int right = col < n - 1 ? dp[col + 1] : Integer.MAX_VALUE;
                cur[col] = grid[row][col] + Math.min(down, Math.min(left, right));
            }
            dp = cur;
        }

        int min = Integer.MAX_VALUE;
        for (int val : dp)
            min = Math.min(min, val);

        System.out.println(min);
    }
}
