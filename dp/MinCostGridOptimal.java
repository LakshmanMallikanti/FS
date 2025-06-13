import java.util.*;

public class MinCostGridOptimal {
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
        System.out.print(MinPathCost(grid, n, m));
    }

    static int MinPathCost(int[][] grid, int n, int m) {
        if (grid[0][0] == -1)
            return -1;

        int[] prev = new int[m];

        for (int i = 0; i < n; i++) {
            int[] cur = new int[m];
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == -1) {
                    cur[j] = Integer.MAX_VALUE;
                } else if (i == 0 && j == 0) {
                    cur[j] = grid[i][j];
                } else {
                    int up = (i > 0 && prev[j] != Integer.MAX_VALUE) ? prev[j] : Integer.MAX_VALUE;
                    int left = (j > 0 && cur[j - 1] != Integer.MAX_VALUE) ? cur[j - 1] : Integer.MAX_VALUE;
                    cur[j] = (up == Integer.MAX_VALUE && left == Integer.MAX_VALUE) ? Integer.MAX_VALUE
                            : Math.min(up, left) + grid[i][j];
                }
            }
            prev = cur;
        }

        return prev[m - 1] == Integer.MAX_VALUE ? -1 : prev[m - 1];
    }
}
