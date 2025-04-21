package backtracking;

import java.util.*;

public class SquarePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = paths(0, 0, n);
        System.out.println(res);
    }

    static int paths(int r, int c, int n) {
        if (r == n - 1 && c == n - 1) {
            return 1;
        }
        if (r >= n || c >= n) {
            return 0;
        }
        int down = paths(r + 1, c, n);
        int right = paths(r, c + 1, n);
        return down + right;
    }
}
