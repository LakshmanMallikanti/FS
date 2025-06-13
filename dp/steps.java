
import java.util.Arrays;

public class steps {
    static int[] dp;

    public static void main(String[] args) {
        int n = 10;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(climbStairs(n));
    }

    static int climbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }
}
