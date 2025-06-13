import java.util.Arrays;

public class fib {
    static int[] dp;

    static int fib(int n) {
        if (n <= 1)
            return n;

        if (dp[n] != -1)
            return dp[n]; // Check memo

        return dp[n] = fib(n - 1) + fib(n - 2); // Memoize
    }

    public static void main(String[] args) {
        int n = 10;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println("Fibonacci of " + n + " is: " + fib(n));
    }
}
