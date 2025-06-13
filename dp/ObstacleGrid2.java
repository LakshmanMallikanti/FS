import java.util.*;

public class ObstacleGrid2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] Grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Grid[i][j] = sc.nextInt();
            }
        }
        if (Grid[0][0] == 1) {
            System.out.println(0);
            return;
        }
        System.out.print(UniquePaths(Grid, n, m));
    }

    static int UniquePaths(int[][] grid, int n, int m) {
        int dp[][] = new int[n][m];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0)
                        dp[i][j] += dp[i - 1][j];
                    if (j > 0)
                        dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
