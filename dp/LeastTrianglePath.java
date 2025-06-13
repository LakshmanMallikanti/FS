
/*
 * You are given a triangle array like this:
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
Each step, you may move to adjacent numbers on the row below.
That is, if you are on index i in row r, you may move to index i or i+1 in row r+1.

🔽 Return the minimum total from top to bottom.
 */
import java.util.*;

public class LeastTrianglePath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> k = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                k.add(sc.nextInt());
            }
            triangle.add(k);
        }
        System.out.print(leastPath(triangle));
    }

    static int leastPath(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
            }
        }
        return dp[0];
    }
}
