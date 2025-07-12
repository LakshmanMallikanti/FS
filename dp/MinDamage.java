import java.util.*;

public class MinDamage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (i == n - 1)
                    dp[j] = arr[i][j];
            }
        }
        System.out.println(Arrays.toString(dp));
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j - 1 >= 0)
                    dp[j] = Math.min(dp[j], dp[j - 1]) + arr[i][j];
                if (j + 1 < n)
                    dp[j] = Math.min(dp[j], dp[j + 1]) + arr[i][j];
            }
            System.out.println(Arrays.toString(dp));
        }
        int res = Integer.MAX_VALUE;
        for (int i : dp) {
            res = Math.min(i, res);
        }
        System.out.print(res);
    }
}