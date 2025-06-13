
/*
A n x m grid has some obstacles. You can only move right or down.
obstacleGrid[i][j] == 1 means the cell is blocked, 0 means it's free.
Find the number of ways to reach bottom-right from top-left.


*/
import java.util.*;;

public class ObstacleGrid {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int grid[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        if (grid[0][0] == 1) {
            System.out.println(0);
            return;
        }

        System.out.println(countPaths(n - 1, m - 1, grid));
    }

    static int countPaths(int n, int m, int[][] grid) {
        if (n < 0 || m < 0 || grid[n][m] == 1) {
            return 0; // Out of bounds or obstacle
        }
        if (n == 0 && m == 0) {
            return 1; // Reached the destination
        }
        if (dp[n][m] != -1) {
            return dp[n][m]; // Return cached result
        }
        // Count paths from the cell above and the cell to the left
        return dp[n][m] = countPaths(n - 1, m, grid) + countPaths(n, m - 1, grid);
    }

}
